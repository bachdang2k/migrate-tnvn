package com.vivas.migratectxh.dao.oracle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "ACCOUNT")
public class Account
{
    @Id
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "CAT_TINH_ID")
    private Integer catTinhId;

    @Column(name = "CAT_QUAN_ID")
    private Integer catQuanId;

    @Column(name = "CAT_XA_ID")
    private Integer catXaId;

    @Column(name = "AVATAR")
    private String avatar;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "GENDER")
    private Integer gender;

    @Column(name = "NOTIFICATION")
    private Integer notification;

    @Column(name = "MNP")
    private String mnp;

    @Column(name = "CHUC_VU_DOAN_ID")
    private Integer chucVuDoanId;

    @Column(name = "MA_QR")
    private String maQr;

    @Column(name = "CCCD_ID")
    private String cccdId;

    @Column(name = "CCCD_NGAY_CAP")
    private Date cccdNgayCap;

    @Column(name = "CCCD_NOI_CAP")
    private String cccdNoiCap;

    @Column(name = "CCCD_THUONG_TRU")
    private String cccdThuongTru;

    @Column(name = "DANTOC_ID")
    private Integer danTocId;

    @Column(name = "TON_GIAO")
    private String tonGiao;

    @Column(name = "VAN_HOA_ID")
    private Integer vanHoaId;

    @Column(name = "CHUYEN_MON_ID")
    private Integer chuyenMonId;

    @Column(name = "TIN_HOC_ID")
    private Integer tinHocId;

    @Column(name = "NGOAI_NGU_ID")
    private Integer ngoaiNguId;

    @Column(name = "CHINH_TRI_ID")
    private Integer chinhTriId;

    @Column(name = "QUEQUAN_TINH_ID")
    private Integer queQuanTinhId;

    @Column(name = "QUEQUAN_QUAN_ID")
    private Integer queQuanQuanId;

    @Column(name = "QUEQUAN_XA_ID")
    private Integer queQuanXaId;

    @Column(name = "YUM_UPDATE_STATUS")
    private Integer yumUpdateStatus;

    @Column(name = "SYNCH_STATUS")
    private Integer syncStatus;

    @Column(name = "IS_EKYC")
    private Integer isEKYC;

    @Column(name = "NGAY_VAO_DOAN")
    private Date ngayVaoDoan;

}
