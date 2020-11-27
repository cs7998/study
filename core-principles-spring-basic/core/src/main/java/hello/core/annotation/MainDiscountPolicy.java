package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy") // 문자열은 컴파일시 타입체크가 안된다.
public @interface MainDiscountPolicy {
    // MainDiscountPolicy 에서 커서 위치한 상태로 Ctrl + B 하면 코드 추적
}
