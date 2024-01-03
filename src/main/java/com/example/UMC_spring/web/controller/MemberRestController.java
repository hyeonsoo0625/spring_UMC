package com.example.UMC_spring.web.controller;

import com.example.UMC_spring.apiPayload.ApiResponse;
import com.example.UMC_spring.web.dto.MemberRequestDTO;
import com.example.UMC_spring.web.dto.MemberResponseDTO;
import com.example.UMC_spring.web.service.MemberService.MemberCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        return null;
    }
}
