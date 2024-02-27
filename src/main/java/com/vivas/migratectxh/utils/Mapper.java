package com.vivas.migratectxh.utils;

import com.vivas.migratectxh.entity.mysql.BannersM;
import com.vivas.migratectxh.entity.oracle.Banners;

public class Mapper {

    public static BannersM toBannerM(Banners bannerO) {
        BannersM banner = new BannersM();

        return banner;
    }

}
