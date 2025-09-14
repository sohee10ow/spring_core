package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicInfoText {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findBeanByName( ) {
        MemberService memberService = context.getBean("memberService",MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);


    }

    @Test
    @DisplayName("모든 빈 출력하기")
    void findBeanByType( ) {
        MemberService memberService = context.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }



    @Test
    @DisplayName("구체 타입으로 조회 => 유연성이 떨어짐 ")
    void findBeanByName2( ) {
        MemberService memberService = context.getBean("memberService",MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);


    }

    @Test
    @DisplayName("빈 이름으로 조회 X ")
    void findBeanByNameX( ) {
        //org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'XXXXXXX' available
        //context.getBean("XXXXXXX",MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> context.getBean("XXXXXXX",MemberService.class));
    }

}
