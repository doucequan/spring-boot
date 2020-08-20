package com.zhumj.component;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
public class UserService {

    public void printName(String name) {
        System.out.println("my name is " + name);
    }


    public String doSome(String str) {
        return str;
    }

}
