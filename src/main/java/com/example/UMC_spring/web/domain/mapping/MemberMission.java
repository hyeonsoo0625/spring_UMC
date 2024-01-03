package com.example.UMC_spring.web.domain.mapping;

import com.example.UMC_spring.web.domain.Member;
import com.example.UMC_spring.web.domain.Mission;
import com.example.UMC_spring.web.domain.common.BaseEntity.BaseEntity;
import com.example.UMC_spring.web.domain.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Mission mission;
}