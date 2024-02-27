package com.vivas.migratectxh.controller;

import com.vivas.migratectxh.entity.mysql.CategoriesM;
import com.vivas.migratectxh.entity.mysql.PostsM;
import com.vivas.migratectxh.repository.mysql.MCategoryRepository;
import com.vivas.migratectxh.repository.mysql.MPostRepository;
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
public class Controller {

    private final MPostRepository repository;

    private final MCategoryRepository categoryRepository;


    @GetMapping("/all_posts")
    public ResponseEntity<List<PostsM>> getAllPost() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/all_categories")
    public ResponseEntity<List<CategoriesM>> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.findAll());
    }

}
