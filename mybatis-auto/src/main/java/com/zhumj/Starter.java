package com.zhumj;

import com.zhumj.mapper.MemberMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.io.IOException;

@SpringBootApplication
public class Starter {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Starter.class, args);

        MemberMapper bean = context.getBean(MemberMapper.class);

        int count = bean.count(1);
        System.out.println(count);


    }

//    public static void main(String[] args) throws IOException {
//
//
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
//
//        int count = mapper.count(1);
//
//        System.out.println(count);
//
//
//    }
}
