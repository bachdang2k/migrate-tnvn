package com.vivas.migratectxh.dao.oracle.repo;

import com.vivas.migratectxh.dao.oracle.entity.Banners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banners, Long> {
}
