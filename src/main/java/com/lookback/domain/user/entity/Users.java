package com.lookback.domain.user.entity;

import com.lookback.domain.common.constant.enums.UserTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "USERS")
@Builder
@AllArgsConstructor
public class Users {

    @Id @GeneratedValue
    @Column(name = "USERS_ID")
    private Long id;

    @Column(nullable = false, unique = true)
    private String kakaoId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERS_ID")
    private Trainer trainer;

    private String email;
    private String password;
    private String phone;
    private Long birthDt;
    private double weight;
    private double height;
    private String snsProvider;
    private String snsId;
    private String userName;
    private String nickName;
    private String profileImageUrl;
    private String verified; //본인인증 여부
    private String gender;
    private LocalDateTime signupDate; //가입일
    private LocalDateTime lastLoginDate;
    private String status; //계정상태
    @Enumerated(EnumType.STRING)
    private UserTypeEnum userType;
    private String isProfileComplete;

    @Column(length = 500)
    private String refreshToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Users() {
    }

    public Users(Long id, String email, String password, String snsProvider, String snsId, String userName, String nickName, String profileImageUrl, String phone, String verified, String gender, LocalDateTime signupDate, LocalDateTime lastLoginDate, String status, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.snsProvider = snsProvider;
        this.snsId = snsId;
        this.userName = userName;
        this.nickName = nickName;
        this.profileImageUrl = profileImageUrl;
        this.phone = phone;
        this.verified = verified;
        this.gender = gender;
        this.signupDate = signupDate;
        this.lastLoginDate = lastLoginDate;
        this.status = status;
        this.updatedAt = updatedAt;
    }

    public static Users createUser(String kakaoId, String email, String nickName, String profileImage) {
        Users user = new Users();
        user.builder()
                .kakaoId(kakaoId)
                .email(email)
                .nickName(nickName)
                .profileImageUrl(profileImage)
                .build();

        return user;
    }

    public String getUserTypeStr() {
        return this.userType.name();
    }

    public static UserTypeEnum getUserType(String userType) {
        return userType.equals("TRAINER") ?
                UserTypeEnum.TRAINER : UserTypeEnum.MEMBER;
    }

}
