package Spring.cores.order;

import Spring.cores.AppConfig;
import Spring.cores.member.Grade;
import Spring.cores.member.Member;
import Spring.cores.member.MemberService;
import Spring.cores.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

  MemberService memberService;
  OrderService orderService;

  @BeforeEach //test를 실행하기 전에 무조건 실행되는 것
  public void beforeEach(){
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
  }

  @Test
  void createOrder(){
    Long memberId = 1L;
    Member member = new Member(memberId, "membera", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}
