package org.sopt.diary.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hsb_member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // ID 역할을 할거임
    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nick_name", nullable = false)
    private String nickName;

    public MemberEntity(String userName, String password, String nickName) {
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
    }

    public MemberEntity() {

    }

    public Long getId() {
        return id;
    }
}
