package com.demo.mybatis.mapper;

import com.demo.mybatis.pojo.UserCopy;
import org.apache.ibatis.jdbc.SQL;

public class UserCopySqlProvider {

    public String insertSelective(UserCopy record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_copy");
        
        if (record.getId1() != null) {
            sql.VALUES("id1", "#{id1,jdbcType=INTEGER}");
        }
        
        if (record.getName1() != null) {
            sql.VALUES("name1", "#{name1,jdbcType=VARCHAR}");
        }
        
        if (record.getAge1() != null) {
            sql.VALUES("age1", "#{age1,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserCopy record) {
        SQL sql = new SQL();
        sql.UPDATE("user_copy");
        
        if (record.getName1() != null) {
            sql.SET("name1 = #{name1,jdbcType=VARCHAR}");
        }
        
        if (record.getAge1() != null) {
            sql.SET("age1 = #{age1,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id1 = #{id1,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}