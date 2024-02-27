package com.vivas.migratectxh.utils;

import com.vivas.migratectxh.dao.mysql.entity.BannersM;
import com.vivas.migratectxh.dao.oracle.entity.Banners;

public class Mapper {

    public static BannersM toBannerM(Banners bannerO) {
        BannersM banner = new BannersM();

        return banner;
    }

}
