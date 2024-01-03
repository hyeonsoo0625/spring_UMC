package com.example.UMC_spring.web.domain;

import com.example.UMC_spring.web.domain.common.BaseEntity.BaseEntity;
import com.example.UMC_spring.web.domain.enums.Gender;
import com.example.UMC_spring.web.domain.enums.MemberStatus;
import com.example.UMC_spring.web.domain.enums.SocialType;
import com.example.UMC_spring.web.domain.mapping.MemberAgree;
import com.example.UMC_spring.web.domain.mapping.MemberMission;
import com.example.UMC_spring.web.domain.mapping.MemberPrefer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity //JPA의 엔티티임을 명시
@Getter //getter 만들어줌
@DynamicInsert
@DynamicUpdate
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 만드는 방법
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING) //enum을 entity에 적용
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    // @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("0")
    private Integer point;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPrefersList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
