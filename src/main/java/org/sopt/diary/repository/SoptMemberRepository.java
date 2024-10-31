package org.sopt.diary.repository;

import org.sopt.diary.repository.SoptMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoptMemberRepository extends JpaRepository<SoptMemberEntity, Long> {

}
