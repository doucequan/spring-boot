package com.zhumj.transaction;

import com.zhumj.transaction.manager.MemberManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Start {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Start.class, args);

        MemberManager bean = context.getBean(MemberManager.class);

        int result = bean.updateName("胡歌", 1);
    }

}
