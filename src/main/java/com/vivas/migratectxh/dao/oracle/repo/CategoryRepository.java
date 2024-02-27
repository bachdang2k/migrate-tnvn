package com.vivas.migratectxh.dao.oracle.repo;

import com.vivas.migratectxh.dao.oracle.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
}
