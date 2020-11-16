package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // new Memo.. 구현체 목록중 해당하는 것 선택후 Ctrl(Cmd) + Shift + Enter 하면 (); 까지 자동 입력

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
