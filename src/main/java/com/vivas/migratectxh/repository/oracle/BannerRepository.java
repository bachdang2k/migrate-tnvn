package com.vivas.migratectxh.repository.oracle;

import com.vivas.migratectxh.entity.oracle.Banners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banners, Long> {
}
