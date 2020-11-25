package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration   // Configuraton 을 주석 처리하면 싱글톤 보장되지 않는다. CGLIB
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()
    // singleton ??? new ???

    // 예상 호출
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository

    // 실제 호출
    // call AppConfig.memberService
    // call AppConfig.memberRepository - 예상과 다르게 한번만 호출됨 - 스프링에서 한번만 호출하도록..
    // call AppConfig.orderService

    @Bean
    public MemberService memberService() {
        // 생성자 주입 > Ctrl + Alt + M : extract method
        // soutm : 현재 클래스와 메스드 이름 출력
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
