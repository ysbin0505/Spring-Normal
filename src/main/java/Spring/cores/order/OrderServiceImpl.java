package Spring.cores.order;

import Spring.cores.discount.DiscountPolicy;
import Spring.cores.discount.FixDiscountPolicy;
import Spring.cores.discount.RateDiscountPolicy;
import Spring.cores.member.Member;
import Spring.cores.member.MemberRepository;
import Spring.cores.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

  /*private final MemberRepository memberRepository = new MemoryMemberRepository();
  //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
  //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
  private final DiscountPolicy discountPolicy;    //인터페이스에만 의존하도록 구현 but NPE 발생, 이 문제를 해결하려면
                                            //OrderServiceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 주입
  */
  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  @Autowired
  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
  
  //테스트 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
