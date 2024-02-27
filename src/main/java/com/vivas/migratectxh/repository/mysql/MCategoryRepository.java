package com.vivas.migratectxh.repository.mysql;

import com.vivas.migratectxh.entity.mysql.CategoriesM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MCategoryRepository extends JpaRepository<CategoriesM, Long> {
}
