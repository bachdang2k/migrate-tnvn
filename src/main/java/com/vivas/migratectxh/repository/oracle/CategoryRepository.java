package com.vivas.migratectxh.repository.oracle;

import com.vivas.migratectxh.entity.oracle.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
}
