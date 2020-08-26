package com.zhumj;

import com.zhumj.mybatis.mapper.MemberMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
