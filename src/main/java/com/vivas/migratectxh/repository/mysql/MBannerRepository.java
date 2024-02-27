package com.vivas.migratectxh.repository.mysql;

import com.vivas.migratectxh.entity.mysql.BannersM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MBannerRepository extends JpaRepository<BannersM, Long> {
}
