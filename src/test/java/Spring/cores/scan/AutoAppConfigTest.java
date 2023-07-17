package Spring.cores.scan;

import Spring.cores.AppConfig;
import Spring.cores.AutoAppConfig;
import Spring.cores.member.MemberRepository;
import Spring.cores.member.MemberService;
import Spring.cores.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

  @Test
  void basicscan(){
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberService memberService = ac.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);

    OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
    MemberRepository memberRepository = bean.getMemberRepository();
    System.out.println("memberRepository = " + memberRepository);
  }
}
