package Spring.cores.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

  @Test
  public void lifeCycleTest(){
    ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
    NetworkClient client = ac.getBean(NetworkClient.class);

    // 외부에서 setUrl() 메서드 호출
    client.setUrl("http://modified-url.dev");

    // 초기화 작업 메서드 호출
    client.init();

    ac.close();
  }

  @Configuration
  static class LifeCycleConfig{
    @Bean(initMethod = "init") // 초기화 메서드 지정
    public NetworkClient networkClient(){
      NetworkClient networkClient = new NetworkClient();
      networkClient.setUrl("http://hello-spring.dev");
      return networkClient;
    }
  }
}
