package com.ohgiraffers.java;


import com.ohgiraffers.common.Member;
import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);

        System.out.println(memberDAO.findMemberBySequence(1));
        System.out.println(memberDAO.save(new Member(3, "user03", "pass03", "효정임당")));
        System.out.println(memberDAO.findMemberBySequence(3));
    }
}
