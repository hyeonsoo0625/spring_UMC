package com.example.UMC_spring.repository;

import com.example.UMC_spring.web.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
