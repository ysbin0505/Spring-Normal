package Spring.cores;

import Spring.cores.member.Grade;
import Spring.cores.member.Member;
import Spring.cores.member.MemberService;
import Spring.cores.member.MemberServiceImpl;

public class MemberApp {
  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("new member = " + member.getName());
    System.out.println("findMember = " + findMember.getName());
  }
}
