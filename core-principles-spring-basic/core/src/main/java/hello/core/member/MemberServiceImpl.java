package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component("service") conflictingBeanDefinitionException
@Component
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository; // = new MemoryMemberRepository();
    // MemoryMemberRepository 에 더이상 의존하지 않는다.
    // 객체를 생성하고 연결하는 역할
    // 실행하는 역할이 명확하게 분리되었다.

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // new Memo.. 구현체 목록중 해당하는 것 선택후 Ctrl(Cmd) + Shift + Enter 하면 (); 까지 자동 입력
    // new Memo... 구현제 한 칸 앞에서 Ctrl + Alt + V : Memo... memo.. = 자동 생성됨



    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // ConfigurationSingletonTest 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
