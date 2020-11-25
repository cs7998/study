package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component("service") conflictingBeanDefinitionException
@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; // = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        // memberRepository.findById(memberId); 만 입력 상태에서 Ctrl + Alt + V 누르면 Member member = 생성 가능
        // memberRepository 한 칸 앞에 커서 위치한 상태에서
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // ConfigurationSingletonTest 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
