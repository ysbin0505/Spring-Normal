package SimpleBoard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  // 추가적인 쿼리 메서드나 커스텀 쿼리 작성 가능
}

