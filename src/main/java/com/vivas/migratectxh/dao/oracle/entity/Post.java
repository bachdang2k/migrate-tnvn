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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tnvn_content")
public class Post {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "info")
    private String info;

    @Column(name = "image")
    private String image;

    @Column(name = "author")
    private String author;

    @Column(name = "hash_Tag")
    private String hashTags;

    @Column(name = "status")
    private Integer status;

    @Column(name = "source")
    private String source;

    @Column(name = "create_Time")
    private Date createTime;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "on_Main_Page")
    private Integer onMainPage;

    @Column(name = "synch_status")
    private Integer syncStatus;

    @Column(name = "view_count")
    private Long viewCount;

    @Column(name = "web_View_Link")
    private String webViewLink;

    @Column(name = "original_id")
    private Integer originalId;

    @Column(name = "updateTime")
    private Date updateTime;

    @Column(name = "user_id_create")
    private Integer userIdCreate;

    @Column(name = "user_id_approve")
    private Integer userIdApprove;

    @Column(name = "isall")
    private Short isAll;

    @Column(name = "filePath")
    private String filePath;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_size")
    private Integer fileSize;

    @Column(name = "video_link")
    private String videoLink;

    @Column(name = "is_pin")
    private Short isPin;

    @Column(name = "fakeViewCount")
    private Long fakeViewCount;

}
