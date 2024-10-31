package org.sopt.diary.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    boolean existsByNickName(String nickName);

    Optional<MemberEntity> findByNickNameAndPassword(String nickName, String password);

    default MemberEntity findByNickNameAndPasswordOrThrow(String nickName, String password) {
        return findByNickNameAndPassword(nickName, password)
                .orElseThrow(() -> new IllegalArgumentException());
    }
}