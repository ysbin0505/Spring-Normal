package Spring.cores.xml;

import Spring.cores.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContent {
  @Test
  void xmlAppContent(){
    ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

  }
}
