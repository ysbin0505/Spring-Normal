package SimpleBoard;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @Column(columnDefinition = "TEXT")
  private String content;

  // 생성자, getter, setter 등의 메서드 생략

  public void setId(Long id) {
    this.id = id;
  }
}


