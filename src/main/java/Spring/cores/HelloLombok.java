package Spring.cores;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class HelloLombok {
  private String name;
  private int age;

  public static void main(String[] args){
    HelloLombok helloLombok = new HelloLombok();
    helloLombok.setName("asdf");
    helloLombok.setAge(3);

    /*String name = helloLombok.getName();
    Integer age = helloLombok.getAge();
    System.out.println("name = " + name);
    System.out.println("age = " + age);*/

    System.out.println("helloLombok = " + helloLombok);
  }
}
