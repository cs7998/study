package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자 10000원 주문
        int userAPrice = statefulService1.order("UserA", 10000);
        // ThreadB : B사용자 20000원 주문
        int userBPrice = statefulService2.order("UserB", 20000);

        // ThreadA : A사용자 주문금액 조회
        //int price = statefulService1.getPrice();


        // A의 주문 금액이 20000 으로 조회 된다.
        // 같은 인스턴스 객체이므로 statefulService1, statefulService2 이름은 다른지만만
        //System.out.println("price = " + price);
        System.out.println("price = " + userAPrice);

        //assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}