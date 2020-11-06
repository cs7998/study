package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    // 저장 조회 업데이트 삭제는 query 작성 필요 없음 primary key 기반

    // primary key 기반 아닌 나머지는 jpql 작성해야 한다.


    @Override
    public Member save(Member member) {
        // insert query 생성할 필요 없음
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        // jpql 객체지향 쿼리
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // inline variable alt+shiht+enter for windows
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
