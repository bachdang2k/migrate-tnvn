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
@Getter @Setter
@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @Column(name = "id")
    private Long Id;

    @Column(name = "create_at")
    private Date createTime;

    @Column(name = "update_at")
    private Date updateTime;

    @Column(name = "catname")
    private String name;

    @Column(name = "parentid")
    private Integer parentId;

    @Column(name = "motherid")
    private Integer motherId;

    @Column(name = "catlevel")
    private Short level;

    @Column(name = "cattype")
    private Short type;

    @Column(name = "pathid")
    private String pathId;

    @Column(name = "catstatus")
    private Short status;

    @Column(name = "catorder")
    private Integer position;

    @Column(name = "childs")
    private Integer childNum;

}
