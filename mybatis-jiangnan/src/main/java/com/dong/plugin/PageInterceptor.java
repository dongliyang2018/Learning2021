package com.dong.plugin;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @version 1.0 2021/5/3
 * @author dongliyang
 */
@Intercepts(@Signature(type = Executor.class,
method = "query",args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public class PageInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement)args[0];
        Object parameterObject = args[1];
        RowBounds rowBounds = (RowBounds)args[2];
        //需要分页
        if (rowBounds != RowBounds.DEFAULT) {
            Executor executor = (Executor) invocation.getTarget();
            BoundSql boundSql = ms.getBoundSql(parameterObject);
            Field additionalParametersField = BoundSql.class.getDeclaredField("additionalParameters");
            additionalParametersField.setAccessible(true);
            Map<String,Object> additionalParameters = (Map<String, Object>) additionalParametersField.get(boundSql);

            if (rowBounds instanceof PageRowBounds) {
                MappedStatement countMs = newMappedStatement(ms,Long.class);
                CacheKey countKey = executor.createCacheKey(countMs, parameterObject, RowBounds.DEFAULT, boundSql);
                String countSql = "select count(1) from (" + boundSql + ")" + " temp";
                BoundSql countBoundSql = new BoundSql(ms.getConfiguration(), countSql, boundSql.getParameterMappings(), parameterObject);
                Set<String> keySet = additionalParameters.keySet();
                for (String key : keySet) {
                    countBoundSql.setAdditionalParameter(key, additionalParameters.get(key));
                }
                List<Object> countQueryResult = executor.query(countMs, parameterObject, RowBounds.DEFAULT, (ResultHandler) args[3], countKey, countBoundSql);
                Long total = (Long)countQueryResult.get(0);
                ((PageRowBounds) rowBounds).setTotal(total);
            }

            CacheKey pageKey = executor.createCacheKey(ms, parameterObject, rowBounds, boundSql);
            pageKey.update("RowBounds");
            String pageSql = boundSql.getSql() + " limit " + rowBounds.getOffset() + "," + rowBounds.getLimit();
            BoundSql pageBoundSql = new BoundSql(ms.getConfiguration(), pageSql, boundSql.getParameterMappings(), parameterObject);
            Set<String> keySet = additionalParameters.keySet();
            for (String key : keySet) {
                pageBoundSql.setAdditionalParameter(key, additionalParameters.get(key));
            }
            List<Object> list = executor.query(ms, parameterObject, RowBounds.DEFAULT, (ResultHandler) args[3], pageKey, pageBoundSql);
            return list;
        }
        return invocation.proceed();
    }

    private MappedStatement newMappedStatement(MappedStatement ms, Class<Long> typeClazz) {
        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId() + "_count", ms.getSqlSource(), ms.getSqlCommandType());
        ResultMap resultMap = new ResultMap.Builder(ms.getConfiguration(),ms.getId(),typeClazz,new ArrayList<>(0)).build();
        builder.resource(ms.getResource()).fetchSize(ms.getFetchSize())
                .statementType(ms.getStatementType())
                .timeout(ms.getTimeout())
                .parameterMap(ms.getParameterMap())
                .resultSetType(ms.getResultSetType())
                .cache(ms.getCache())
                .flushCacheRequired(ms.isFlushCacheRequired())
                .useCache(ms.isUseCache())
                .resultMaps(Arrays.asList(resultMap));

        return builder.build();
    }
}
