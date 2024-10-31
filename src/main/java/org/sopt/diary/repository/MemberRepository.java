package org.sopt.diary.repository;

import java.util.Optional;
import org.sopt.diary.exception.CustomException;
import org.sopt.diary.exception.ErrorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    boolean existsByNickName(String nickName);

    Optional<MemberEntity> findByNickNameAndPassword(String nickName, String password);

    default MemberEntity findByNickNameAndPasswordOrThrow(String nickName, String password) {
        return findByNickNameAndPassword(nickName, password)
                .orElseThrow(() -> new CustomException(ErrorType.MEMBER_NOTFOUND_ERROR));
    }
}
