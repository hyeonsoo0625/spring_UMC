package com.example.UMC_spring.web.service.MemberService;

import com.example.UMC_spring.apiPayload.code.status.ErrorStatus;
import com.example.UMC_spring.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.UMC_spring.converter.MemberConverter;
import com.example.UMC_spring.converter.MemberPreferConverter;
import com.example.UMC_spring.repository.FoodCategoryRepository;
import com.example.UMC_spring.repository.MemberRepository;
import com.example.UMC_spring.web.domain.FoodCategory;
import com.example.UMC_spring.web.domain.Member;
import com.example.UMC_spring.web.domain.mapping.MemberPrefer;
import com.example.UMC_spring.web.dto.MemberRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request){
        Member newMember = MemberConverter.toMember(request);

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
