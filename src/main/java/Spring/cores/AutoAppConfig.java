package Spring.cores;

import Spring.cores.member.MemberRepository;
import Spring.cores.member.MemberServiceImpl;
import Spring.cores.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
 /* @Bean(name = "memoryMemberRepository")
  MemberRepository memberRepository(){
    return new MemoryMemberRepository();
  }
*/
}
