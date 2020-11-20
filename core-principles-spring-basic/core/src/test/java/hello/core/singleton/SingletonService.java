package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    // 자바 클래스 전체에 걸쳐서 하나만 생성 이해가 안가면 Java static 영역에 공부를

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        // 생성자를 private 으로 선언해 다른 곳에서 SignletonService 를 new 로 생성하지 못하도록 막는다.
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    /**
     * 싱글톤 패턴을 구현하는 코드가 많이 들어간다. logic() 위해서..
     * 의존관계상 클라이언트가 구체 클래스에 의존해야 한다. -> DIP 위반
     * 테스트 어려움
     * 내부 속성 변경, 초기화 하기 어렵다
     * private 생성자로 자식 클래스 생성 어렵다
     * ==> 유연성이 떨어진다
     * 안티패턴으로 불린다.
     */

    /**
     * 스프링에서는 싱글톤 컨테이너
     * 싱글톤 패턴을 위한 지저분한 코드가 들어가지 않아도 된다.
     * DIP, OCP, 테스트, private 생성자로 부터 자유롭게 싱글톤을 사용할 수 있다.
     */
}
