package org.sopt.diary.api;

import jakarta.validation.Valid;
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
    ResponseEntity<Long> postMember(
            @Valid @RequestBody final MemberSignUpRequest memberSignUpRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.signUp(memberSignUpRequest));
    }

    @GetMapping("/auth/login")
    ResponseEntity<Void> getMembers() {

        return ResponseEntity.ok().build();
    }
}
