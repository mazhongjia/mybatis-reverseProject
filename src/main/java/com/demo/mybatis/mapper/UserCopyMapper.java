package com.demo.mybatis.mapper;

import com.demo.mybatis.pojo.UserCopy;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserCopyMapper {
    @Delete({
        "delete from user_copy",
        "where id1 = #{id1,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id1);

    @Insert({
        "insert into user_copy (id1, name1, ",
        "age1)",
        "values (#{id1,jdbcType=INTEGER}, #{name1,jdbcType=VARCHAR}, ",
        "#{age1,jdbcType=INTEGER})"
    })
    int insert(UserCopy record);

    @InsertProvider(type=UserCopySqlProvider.class, method="insertSelective")
    int insertSelective(UserCopy record);

    @Select({
        "select",
        "id1, name1, age1",
        "from user_copy",
        "where id1 = #{id1,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id1", property="id1", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name1", property="name1", jdbcType=JdbcType.VARCHAR),
        @Result(column="age1", property="age1", jdbcType=JdbcType.INTEGER)
    })
    UserCopy selectByPrimaryKey(Integer id1);

    @UpdateProvider(type=UserCopySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserCopy record);

    @Update({
        "update user_copy",
        "set name1 = #{name1,jdbcType=VARCHAR},",
          "age1 = #{age1,jdbcType=INTEGER}",
        "where id1 = #{id1,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserCopy record);
}