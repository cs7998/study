package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {
    // implements InitializingBean, DisposableBean 스프링 전용 인터페이스에 의존, (초기화, 소멸)메소드 이름 변경 불가능
    // 내가 코드를 수정할 수 없는 외부 라이브러리에 적용 불가능 최근에는 거의 쓰지 않는다.

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + " message = "+message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close = " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 의존관계 주입이 끝나면 호출됨
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
