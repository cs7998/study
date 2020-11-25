package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
        // 다른 *.java 의 @Configuration 으로 등록된 Bean 을 등록하지 않기 위해서 제외함, 기존 예제 코드 남기고 유지 하기 위해서
)
public class AutoAppConfig {

}
