package org.sopt.diary.api;

import java.util.List;
import org.sopt.diary.repository.SoptMemberEntity;
import org.sopt.diary.repository.SoptMemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final SoptMemberRepository soptMemberRepository;

    public MemberController(SoptMemberRepository soptMemberRepository) {
        this.soptMemberRepository = soptMemberRepository;
    }

    @PostMapping("/member")
    void postMember() {
        soptMemberRepository.save(new SoptMemberEntity("석범", 25));
    }

    @GetMapping("members")
    ResponseEntity<String> getMembers() {
        List<SoptMemberEntity> all = soptMemberRepository.findAll();

        return ResponseEntity.ok(all.stream().findFirst().get().toString());
    }
}
