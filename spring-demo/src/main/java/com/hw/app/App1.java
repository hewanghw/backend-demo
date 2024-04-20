package com.hw.app;

import com.hw.bean.Cat;
import com.hw.bean.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);
        Dog dog = ctx.getBean("dog1",Dog.class);
        System.out.println(dog);
        String[] names = ctx.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }
    }
}
