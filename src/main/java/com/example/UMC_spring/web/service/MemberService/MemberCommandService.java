package com.example.UMC_spring.web.service.MemberService;

import com.example.UMC_spring.web.domain.Member;
import com.example.UMC_spring.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
