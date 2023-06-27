package Spring.cores.order;

import Spring.cores.discount.DiscountPolicy;
import Spring.cores.discount.FixDiscountPolicy;
import Spring.cores.member.Member;
import Spring.cores.member.MemberRepository;
import Spring.cores.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository = new MemoryMemberRepository();
  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
