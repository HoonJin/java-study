package com.hoonjin.study.spring.rest1.post;

import com.hoonjin.study.spring.rest1.exception.UserNotFoundException;
import com.hoonjin.study.spring.rest1.user.User;
import com.hoonjin.study.spring.rest1.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/jpa")
@RequiredArgsConstructor
public class PostController {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id, @RequestBody Post post) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("id " + id + " is not found"));

        post.setUser(user);
        postRepository.save(post);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(post.getId())
            .toUri();

        return ResponseEntity.created(uri).body(post);
    }
}
