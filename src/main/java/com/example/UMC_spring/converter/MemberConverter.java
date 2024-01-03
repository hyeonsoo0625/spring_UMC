package com.example.UMC_spring.converter;

import com.example.UMC_spring.web.domain.Member;
import com.example.UMC_spring.web.domain.enums.Gender;
import com.example.UMC_spring.web.dto.MemberRequestDTO;
import com.example.UMC_spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){
        Gender gender = null;
        switch(request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .email(null)
                .memberPrefersList(new ArrayList<>())
                .build();
    }
}
