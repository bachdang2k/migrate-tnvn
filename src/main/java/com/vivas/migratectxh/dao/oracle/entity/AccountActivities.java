package com.vivas.migratectxh.dao.oracle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ACCOUNT_ACTIVITIES")
public class AccountActivities {

    @Id
    public Long ID;

    @Column(name = "ACCOUNT_ID")
    public Long accountId;

    @Column(name = "DOAN_CAP1")
    public String doanCap1;

    @Column(name = "DOAN_CAP2")
    public String doanCap2;

    @Column(name = "DOAN_CAP3")
    public String doanCap3;

    @Column(name = "HOISINHVIEN_CAP1")
    public String hoiSinhVienCap1;

    @Column(name = "HOISINHVIEN_CAP2")
    public String hoiSinhVienCap2;

    @Column(name = "HOISINHVIEN_CAP3")
    public String hoiSinhVienCap3;

    @Column(name = "HOITHANHNIEN_CAP1")
    public String hoiThanhNienCap1;

    @Column(name = "HOITHANHNIEN_CAP2")
    public String hoiThanhNienCap2;

    @Column(name = "HOITHANHNIEN_CAP3")
    public String hoiThanhNienCap3;

    @Column(name = "DOAN_CAP4")
    public String doanCap4;

    @Column(name = "DOAN_CAP5")
    public String doanCap5;

    @Column(name = "DOAN_CAP6")
    public String doanCap6;

    @Column(name = "DOAN_CAP7")
    public String doanCap7;

}
