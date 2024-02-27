package com.vivas.migratectxh.controller;

import com.vivas.migratectxh.dao.mysql.entity.CategoriesM;
import com.vivas.migratectxh.dao.mysql.entity.PostsM;
import com.vivas.migratectxh.dao.mysql.repository.MCategoryRepository;
import com.vivas.migratectxh.dao.mysql.repository.MPostRepository;
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

    private final MPostRepository mPostRepository;

    private final MCategoryRepository mCategoryRepository;

    @GetMapping("/all_posts")
    public ResponseEntity<List<PostsM>> getAllPost() {
        return ResponseEntity.status(HttpStatus.OK).body(mPostRepository.findAll());
    }

    @GetMapping("/all_categories")
    public ResponseEntity<List<CategoriesM>> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(mCategoryRepository.findAll());
    }

}
