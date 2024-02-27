package com.vivas.migratectxh.dao.oracle.repo;

import com.vivas.migratectxh.dao.oracle.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {
}
