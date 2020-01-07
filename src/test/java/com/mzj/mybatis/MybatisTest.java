package com.mzj.mybatis;

import com.demo.mybatis.mapper.UserCopyMapper;
import com.demo.mybatis.mapper.UserMapper;
import com.demo.mybatis.pojo.User;
import com.demo.mybatis.pojo.UserCopy;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * com.demo.mybatis
 *
 * @author Zyy
 * @date 2019/1/26 18:13
 */
public class MybatisTest {
    private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    /**
     * MZJ：这种方式不推荐使用
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        User user = session.selectOne("com.demo.mybatis.mapper.UserMapper.selectByPrimaryKey", 1);
        session.commit();
        logger.info(user.toString());
    }


    @Test
    public void test011() throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserCopyMapper userMapper = sqlSession.getMapper(UserCopyMapper.class);
        UserCopy user = userMapper.selectByPrimaryKey(2);
        logger.info(user.toString());
    }


    @Test
    public void test02() throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(2);
        logger.info(user.toString());
    }

    //user.dir可以用来打印你当然目录地址，如果有需要可以替换配置文件中的地址
    @Test
    public void test03() throws IOException {
        System.out.println(System.getProperty("user.dir"));
    }
}
