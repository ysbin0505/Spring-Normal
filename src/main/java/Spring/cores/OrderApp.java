package Spring.cores;

import Spring.cores.discount.DiscountPolicy;
import Spring.cores.member.Grade;
import Spring.cores.member.Member;
import Spring.cores.member.MemberService;
import Spring.cores.member.MemberServiceImpl;
import Spring.cores.order.Order;
import Spring.cores.order.OrderService;
import Spring.cores.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
  public static void main(String[] args) {
    //MemberService memberService = new MemberServiceImpl();
    //OrderService orderService = new OrderServiceImpl();

    //AppConfig appConfig = new AppConfig();
    //MemberService memberService = appConfig.memberService();
    //OrderService orderService = appConfig.orderService();
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 20000);
    System.out.println("order = " + order);
  }


}
