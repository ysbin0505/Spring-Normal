package Spring.cores.order;

import Spring.cores.member.Grade;
import Spring.cores.member.Member;
import Spring.cores.member.MemberService;
import Spring.cores.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

  MemberService memberService = new MemberServiceImpl();
  OrderService orderService = new OrderServiceImpl();

  @Test
  void createOrder(){
    Long memberId = 1L;
    Member member = new Member(memberId, "membera", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}
