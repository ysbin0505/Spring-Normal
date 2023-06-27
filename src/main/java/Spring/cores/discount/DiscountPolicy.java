package Spring.cores.discount;

import Spring.cores.member.Member;

public interface DiscountPolicy {

  /**dddd
   * @return
   */
  int discount(Member member, int price);

}
