package com.example.UMC_spring.web.domain;

import com.example.UMC_spring.web.domain.common.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
