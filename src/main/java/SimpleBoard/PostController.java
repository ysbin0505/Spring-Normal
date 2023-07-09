package SimpleBoard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public String getAllPosts(Model model) {
    List<Post> posts = postService.getAllPosts();
    model.addAttribute("posts", posts);
    return "post-list"; // post-list.html과 연결
  }

  @GetMapping("/{id}")
  public String getPostById(@PathVariable Long id, Model model) {
    Post post = postService.getPostById(id);
    model.addAttribute("post", post);
    return "post-detail"; // post-detail.html과 연결
  }

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("post", new Post());
    return "post-form"; // post-form.html과 연결
  }

  @PostMapping("/create")
  public String createPost(@ModelAttribute("post") Post post) {
    postService.createPost(post);
    return "redirect:/posts";
  }

  @GetMapping("/{id}/edit")
  public String showEditForm(@PathVariable Long id, Model model) {
    Post post = postService.getPostById(id);
    model.addAttribute("post", post);
    return "post-form"; // post-form.html과 연결
  }

  @PostMapping("/{id}/edit")
  public String updatePost(@PathVariable Long id, @ModelAttribute("post") Post post) {
    post.setId(id);
    postService.updatePost(post);
    return "redirect:/posts";
  }

  @PostMapping("/{id}/delete")
  public String deletePost(@PathVariable Long id) {
    postService.deletePost(id);
    return "redirect:/posts";
  }
}
