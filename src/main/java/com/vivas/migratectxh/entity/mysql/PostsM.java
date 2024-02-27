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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "posts")
public class PostsM {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    private Date createTime;

    @Column(name = "updated_at")
    private Date updateTime;

    @Column(name = "title")
    private String title;

    @Column(name = "ascii_title")
    private String asciiTitle;

    @Column(name = "preview_description")
    private String description;

    @Column(name = "body_description")
    private String body;

    @Column(name = "image_preview")
    private String image;

    @Column(name = "author")
    private String author;

    @Column(name = "tag")
    private String hashTags;

    @Column(name = "status")
    private Integer status;

    @Column(name = "source")
    private String source;

    @Column(name = "position")
    private Integer priority;

    @Column(name = "home_display_enable")
    private Integer onMainPage;

    @Column(name = "read_count")
    private Long viewCount;

    @Column(name = "web_view_link")
    private String webViewLink;

    @Column(name = "created_by")
    private String userIdCreate;

    @Column(name = "approve_by")
    private String userIdApprove;

    @Column(name = "is_all")
    private Short isAll;

    @Column(name = "is_pin")
    private Short isPin;

}
