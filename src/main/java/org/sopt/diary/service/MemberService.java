package org.sopt.diary.service;

import org.sopt.diary.api.dto.MemberLoginRequest;
import org.sopt.diary.api.dto.MemberLoginResponse;
import org.sopt.diary.api.dto.MemberSignUpRequest;
import org.sopt.diary.exception.CustomException;
import org.sopt.diary.exception.ErrorType;
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
    public void signUp(final MemberSignUpRequest memberSignUpRequest) {
        if (memberRepository.existsByNickName(memberSignUpRequest.getNickName())) {
            throw new CustomException(ErrorType.DUPLICATE_NICKNAME_ERROR);
        }
        MemberEntity member = new MemberEntity(memberSignUpRequest.getUserName(), memberSignUpRequest.getPassword(),
                memberSignUpRequest.getNickName());
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public MemberLoginResponse login(MemberLoginRequest memberLoginRequest) {
        MemberEntity member = memberRepository.findByNickNameAndPasswordOrThrow(memberLoginRequest.getNickName(),
                memberLoginRequest.getPassword());
        return new MemberLoginResponse(member.getId());
    }
}
