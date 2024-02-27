package com.vivas.migratectxh.dao.mysql.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "MEMBER")
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "username")
    private String username;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "eidc")
    private String eidc;

    @Column(name = "liv")
    private String liv;

    @Column(name = "city_liv")
    private Integer city;

    @Column(name = "district_liv")
    private Integer district;

    @Column(name = "ward_liv")
    private Integer wards;

    @Column(name = "address")
    private String address;

    @Column(name = "reason_reject")
    private String reasonReject;

    @Column(name = "update_at")
    private Long updateAt;

    @Column(name = "is_channel_admin")
    private Boolean chanelAdmin;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "date_del")
    private Date dateDel;

    @Column(name = "deleted_by")
    private Long deleted_by;

    @Column(name = "doi_citizen_id")
    private Date doiCitizenId;

    @Column(name = "date_in_group")
    private Date dateInGroup;

    @Column(name = "email")
    private String email;

    @Column(name = "city_resident")
    private Integer cityResident;

    @Column(name = "district_resident")
    private Integer districtResident;

    @Column(name = "ward_resident")
    private Integer wardResident;

    @Column(name = "citizen_id")
    private String citizenId;

    @Column(name = "issue_at_citizen")
    private Integer iaCitizen;

    @Column(name = "nation_id")
    private Integer nationId;

    @Column(name = "id_religion")
    private Integer religionId;

    @Column(name = "id_info_sci")
    private Integer infoSciId;

    @Column(name = "id_language")
    private Integer languageId;

    @Column(name = "id_tdpt")
    private Integer tdptId;

    @Column(name = "id_llct")
    private Integer llct;

    @Column(name = "ia_group")
    private String iaGroup;

    @Column(name = "associations_id")
    private Integer assId;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "id_unit_group")
    private Long unitGroupId;

    @Column(name = "loai_htc_id")
    private Long htcType;

    @Column(name = "unit_position_id")
    private Long unitPossitionId;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "issue_at_citizen_name")
    private String issueAtCitizenName;

    @Column(name = "is_app")
    private boolean isApp;

    @Column(name = "union_group")
    private String unionGroup;

    @Column(name = "student_group")
    private String studentGroup;

    @Column(name = "qualification")
    private Integer qualification;

    @Column(name = "yum_id")
    private Long yumId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "delete_at")
    private Boolean deleteAt;

    @Column(name = "account_ekyc")
    private String accountEkyc;

    @Column(name = "channel_id")
    private Long channelId;

    @Column(name = "address_resident")
    private String addressResident;
}
