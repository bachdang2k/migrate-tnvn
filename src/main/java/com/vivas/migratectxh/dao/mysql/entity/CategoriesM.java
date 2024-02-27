package com.vivas.migratectxh.dao.mysql.entity;

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
@Table(name = "categories")
public class CategoriesM {

    @Id
    @Column(name = "id")
    private Long Id;

    @Column(name = "created_at")
    private Date createTime;

    @Column(name = "updated_at")
    private Date updateTime;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "mother_id")
    private Integer motherId;

    @Column(name = "cat_level")
    private Short level;

    @Column(name = "type")
    private Short type;

    @Column(name = "path_id")
    private String pathId;

    @Column(name = "status")
    private Short status;

    @Column(name = "position")
    private Integer position;

    @Column(name = "childs")
    private Integer childNum;

    @Column(name = "app_id")
    private Short appId;

}
