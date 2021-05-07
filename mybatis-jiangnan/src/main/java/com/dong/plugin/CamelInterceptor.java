package com.dong.plugin;

import com.google.common.base.CaseFormat;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 驼峰拦截器
 * @version 1.0 2021/5/3
 * @author dongliyang
 */
@Intercepts(@Signature(type = ResultSetHandler.class,method = "handleResultSets",args = {Statement.class}))
public class CamelInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        List<Object> list = (List<Object>) invocation.proceed();
        for (Object o : list) {
            if (o instanceof Map) {
                Map<String, Object> map = (Map<String, Object>)o;
                HashSet<String> keySet = new HashSet<>(map.keySet());
                for (String key : keySet) {
                    Object val = map.get(key);
                    map.remove(key);
                    map.put(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,key),val);
                }
            }
        }
        return list;
    }
}
