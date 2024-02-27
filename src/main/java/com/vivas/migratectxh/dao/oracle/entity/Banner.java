package com.vivas.migratectxh.dao.oracle.entity;

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
@Table(name = "banner")
public class Banner {

    @Id
    @Column(name = "id")
    private Long Id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "post_ref")
    private Integer postRef;

    @Column(name = "link")
    private String urlRef;

    @Column(name = "type")
    private String type;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private Short status;

    @Column(name = "position")
    private String position;

    @Column(name = "public_date")
    private Date publicDate;

    @Column(name = "app_id")
    private Short appId;
}
