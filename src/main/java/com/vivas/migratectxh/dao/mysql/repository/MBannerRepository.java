package com.vivas.migratectxh.dao.mysql.repository;

import com.vivas.migratectxh.dao.mysql.entity.BannersM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MBannerRepository extends JpaRepository<BannersM, Long> {
}
