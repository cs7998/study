package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
        // 다른 *.java 의 @Configuration 으로 등록된 Bean 을 등록하지 않기 위해서 제외함, 기존 예제 코드 남기고 유지 하기 위해서
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        // Overriding bean definition for bean 'memoryMemberRepository'  스프링은 수동빈이 자동빈을 교체하지만..
//        // 스프링 부트 에서는 에레메세지 발생하면서 overridding 옵션을 주도록 안내문을 에러메세지에 추가함
//        return new MemoryMemberRepository();
//    }

}
