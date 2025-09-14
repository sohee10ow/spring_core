package hello.core.beanfind;

import hello.core.AppConfig;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.target.SingletonTargetSource;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/*
java.lang.IllegalStateException: org.springframework.context.annotation.AnnotationConfigApplicationContext@52719fb6 has not been refreshed yet
AnnotationConfigApplicationContext 를 초기화 하지 않았을 경우
 */
public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBeans( ) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = context.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName = " + beanDefinitionName + "object = " + bean);
        }
    }

    @Test

    @DisplayName("애플리케이션  빈 출력하기")
    void findApplicationBean( ) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = context.getBeanDefinition(beanDefinitionName);
            //애플리케이션에 등록한 빈들을
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = context.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "object = " + bean);
            }
        }
    }

}

