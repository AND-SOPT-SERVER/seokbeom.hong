package org.sopt.diary.service;

import org.sopt.diary.api.dto.MemberSignUpRequest;
import org.sopt.diary.repository.MemberEntity;
import org.sopt.diary.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long signUp(final MemberSignUpRequest memberSignUpRequest) {
        if (memberRepository.existsByNickName(memberSignUpRequest.getNickName())) {
            //todo: 중복 닉네임 방지 에러
        }
        MemberEntity member = new MemberEntity(memberSignUpRequest.getUserName(), memberSignUpRequest.getPassword(),
                memberSignUpRequest.getNickName());
        memberRepository.save(member);
        return 1L;
    }
}
