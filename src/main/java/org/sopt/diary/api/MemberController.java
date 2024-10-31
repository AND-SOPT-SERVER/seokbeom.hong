package org.sopt.diary.api;

import jakarta.validation.Valid;
import org.sopt.diary.api.dto.MemberLoginRequest;
import org.sopt.diary.api.dto.MemberSignUpRequest;
import org.sopt.diary.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/auth/signUp")
    ResponseEntity<Void> postMember(
            @Valid @RequestBody final MemberSignUpRequest memberSignUpRequest
    ) {
        memberService.signUp(memberSignUpRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/auth/login")
    ResponseEntity<Long> getMembers(
            @Valid @RequestBody final MemberLoginRequest memberLoginRequest
            ) {
        return ResponseEntity.ok(memberService.login(memberLoginRequest)).build();
    }
}
