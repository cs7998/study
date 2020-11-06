package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// 서비서의 네이밍 비즈니스 로직에 맞게
// Repository 는 기술적으로 save, Service 는 join
//@Service
@Transactional // MemberService 클래스 전체에 해도 되고 필요한 메소드에만 해도 된다.
public class MemberService {

    private final MemberRepository memberRepository; // = new MemoryMemberRepository();

    //@Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원 가입
     * JPA는 저장시 항상 Transaction 으로 해야 한다.
     */
    public Long join(Member member) {
        // 같은 이름 있는 중복 회원 X
        // result.orElseGet()
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        validateDuplicateMember(member);    // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}