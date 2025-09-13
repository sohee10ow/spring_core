package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
       /* MemberService memberService = new MemberServiceImpl();*/
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        //Appconfig 를 가지고 @Bean 스프링 컨테이너에 객체생성된거를 다 등록을 해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member find = memberService.findeMember(1L);

        System.out.println("new member: " + memberA.getName());
        System.out.println("find member : " + find.getName());

    }
}
