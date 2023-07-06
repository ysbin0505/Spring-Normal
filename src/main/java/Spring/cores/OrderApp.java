package Spring.cores;

import Spring.cores.discount.DiscountPolicy;
import Spring.cores.member.Grade;
import Spring.cores.member.Member;
import Spring.cores.member.MemberService;
import Spring.cores.member.MemberServiceImpl;
import Spring.cores.order.Order;
import Spring.cores.order.OrderService;
import Spring.cores.order.OrderServiceImpl;

public class OrderApp {
  public static void main(String[] args) {
    //MemberService memberService = new MemberServiceImpl();
    //OrderService orderService = new OrderServiceImpl();

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);
    System.out.println("order = " + order);
  }
}
