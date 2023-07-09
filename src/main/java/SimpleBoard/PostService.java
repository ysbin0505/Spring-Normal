package SimpleBoard;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
  private final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public Post getPostById(Long id) {
    return postRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid post ID: " + id));
  }

  public void createPost(Post post) {
    postRepository.save(post);
  }

  public void updatePost(Post post) {
    postRepository.save(post);
  }

  public void deletePost(Long id) {
    postRepository.deleteById(id);
  }
}

