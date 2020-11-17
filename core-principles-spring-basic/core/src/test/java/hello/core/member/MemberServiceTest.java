package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given : 주어진 조건 환경
        Member member = new Member(1L, "name", Grade.VIP);

        // when : 할때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : 결과
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
