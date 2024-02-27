package com.vivas.migratectxh.repository.oracle;

import com.vivas.migratectxh.entity.oracle.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {
}
