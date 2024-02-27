package com.vivas.migratectxh.dao.mysql.repository;

import com.vivas.migratectxh.dao.mysql.entity.PostsM;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface MPostRepository extends JpaRepository<PostsM, Long> {
}
