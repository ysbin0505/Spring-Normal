/*애플리케이션의 전체 동작 방식을 구성(config)하기 위해, "구현 객체를 생성"하고, "연결"하는 책임을 가지는
별도의 설정 클래스를 만들자.*/
package Spring.cores;

import Spring.cores.discount.DiscountPolicy;
import Spring.cores.discount.FixDiscountPolicy;
import Spring.cores.discount.RateDiscountPolicy;
import Spring.cores.member.MemberRepository;
import Spring.cores.member.MemberService;
import Spring.cores.member.MemberServiceImpl;
import Spring.cores.member.MemoryMemberRepository;
import Spring.cores.order.OrderService;
import Spring.cores.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public MemberService memberService(){
    return new MemberServiceImpl(memberRepository());
  }
  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
  @Bean
  public OrderService orderService(){
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }
  @Bean
  public DiscountPolicy discountPolicy(){
    //return new FixDiscountPolicy();
    return new RateDiscountPolicy();
  }
  
}
