package com.vivas.migratectxh.entity.mysql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "banners")
public class BannersM {

    @Id
    @Column(name = "id")
    private Long Id;

    @Column(name = "created_at")
    private Date createTime;

    @Column(name = "updated_at")
    private Date updateTime;

    @Column(name = "title")
    private String title;

    @Column(name = "post_ref")
    private Integer postRef;

    @Column(name = "url_ref")
    private String urlRef;

    @Column(name = "cate_ref")
    private Short cateRef;

    @Column(name = "ref_type")
    private Short type;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private Short status;

    @Column(name = "image")
    private String image;

    @Column(name = "position")
    private String position;

    @Column(name = "public_date")
    private Date publicDate;

    @Column(name = "app_id")
    private Short appId;

}
