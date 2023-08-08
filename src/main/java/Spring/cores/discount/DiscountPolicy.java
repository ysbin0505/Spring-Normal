package Spring.cores.discount;

import Spring.cores.member.Member;
import org.springframework.stereotype.Component;

public interface DiscountPolicy {

  /**
   * @return
   */
  int discount(Member member, int price);

}
