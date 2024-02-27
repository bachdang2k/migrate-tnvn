package com.vivas.migratectxh.dao.mysql.repository;

import com.vivas.migratectxh.dao.mysql.entity.CategoriesM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MCategoryRepository extends JpaRepository<CategoriesM, Long> {
}
