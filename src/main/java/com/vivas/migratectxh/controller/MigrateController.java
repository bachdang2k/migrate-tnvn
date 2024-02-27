package com.vivas.migratectxh.controller;

import com.vivas.migratectxh.dao.oracle.entity.Category;
import com.vivas.migratectxh.dao.oracle.entity.Post;
import com.vivas.migratectxh.dao.oracle.repo.CategoryRepository;
import com.vivas.migratectxh.dao.oracle.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ctxh/migrate")
public class MigrateController {

    private final PostRepository postRepository;

    private final CategoryRepository categoryRepository;

    @GetMapping("/all_posts")
    public ResponseEntity<List<Post>> getAllPost() {
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.findAll());
    }

    @GetMapping("/all_categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.findAll());
    }

}
