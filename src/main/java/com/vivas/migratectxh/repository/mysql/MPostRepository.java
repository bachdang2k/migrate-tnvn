package com.vivas.migratectxh.repository.mysql;

import com.vivas.migratectxh.entity.mysql.PostsM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MPostRepository extends JpaRepository<PostsM, Long> {
}
