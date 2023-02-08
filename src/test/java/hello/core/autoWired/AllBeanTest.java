package hello.core.autoWired;

import hello.core.AppConfig;
import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class AllBeanTest {

    @Test
    void aVoid() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountServer.class);
        Member member = new Member(1l, "name", Grade.VIP);
        DiscountServer bean = ac.getBean(DiscountServer.class);
        int fixDiscountPolicy = bean.discount(member, 10000, "fixDiscountPolicy");
        System.out.println("fixDiscountPolicy = " + fixDiscountPolicy);

        int discount = bean.discount(member, 20000, "rateDiscountPolicy");
        System.out.println("discount = " + discount);
    }

//    @RequiredArgsConstructor

    static class DiscountServer {
        private final Map<String, DiscountPolicy> policyMap;

        DiscountServer(Map<String, DiscountPolicy> policyMap) {
            this.policyMap = policyMap;
            System.out.println("policyMap = " + policyMap);
        }

        public int discount(Member member, int price, String beanName) {
                DiscountPolicy policy = policyMap.get(beanName);
                return policy.discount(member, price);
            }
        }
}
