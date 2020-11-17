package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
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
}
