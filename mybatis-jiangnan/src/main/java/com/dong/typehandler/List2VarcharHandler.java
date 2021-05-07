package com.dong.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义类型转换器
 * @version 1.0 2021/5/3
 * @author dongliyang
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(List.class)
public class List2VarcharHandler implements TypeHandler<List<String>> {

    @Override
    public void setParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        String res = parameter.stream().collect(Collectors.joining(","));
        ps.setString(i, res);
    }

    @Override
    public List<String> getResult(ResultSet rs, String columnName) throws SQLException {
        String res = rs.getString(columnName);
        if (res != null) {
            String[] split = res.split(",");
            return Arrays.asList(split);
        }
        return null;
    }

    @Override
    public List<String> getResult(ResultSet rs, int columnIndex) throws SQLException {
        String res = rs.getString(columnIndex);
        if (res != null) {
            String[] split = res.split(",");
            return Arrays.asList(split);
        }
        return null;
    }

    @Override
    public List<String> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String res = cs.getString(columnIndex);
        if (res != null) {
            String[] split = res.split(",");
            return Arrays.asList(split);
        }
        return null;
    }
}
