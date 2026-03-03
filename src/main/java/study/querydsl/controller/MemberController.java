package study.querydsl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.dto.MemberTeamDto;
import study.querydsl.repository.MemberJpaRepository;
import study.querydsl.repository.MemberRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMembersV1(MemberSearchCondition cond) {
        return memberJpaRepository.search(cond);
    }
    @GetMapping("/v2/members")
    public Page<MemberTeamDto> searchMembersV2(MemberSearchCondition cond, Pageable pageable) {
        return memberRepository.searchPageSimple(cond, pageable);
    }
    @GetMapping("/v3/members")
    public Page<MemberTeamDto> searchMembersV3(MemberSearchCondition cond, Pageable pageable) {
        return memberRepository.searchPageComplex(cond, pageable);
    }
}
