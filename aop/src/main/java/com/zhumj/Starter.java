package com.zhumj;

import com.zhumj.aspect.LogAspect;
import com.zhumj.component.CardServiceImpl;
import com.zhumj.component.UserService;
import com.zhumj.interfaces.CardService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Starter {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(LogAspect.class);
        applicationContext.register(UserService.class);
        applicationContext.register(CardServiceImpl.class);
        applicationContext.refresh();

        UserService userService = applicationContext.getBean(UserService.class);

        CardService cardService = applicationContext.getBean(CardService.class);

        userService.printName("朱梦杰");

        userService.doSome("abcd");

        cardService.printCardName("尊享版");


    }

}
