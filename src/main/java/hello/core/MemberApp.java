package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = context.getBean("memberService", MemberService.class);

        memberService.join(new Member(1L,"member1", Grade.BASIC));
        Member byId = memberService.findById(1L);
        System.out.println("find name: " + byId.getName());
        System.out.println("member Grade: " + byId.getGrade());
    }
}
