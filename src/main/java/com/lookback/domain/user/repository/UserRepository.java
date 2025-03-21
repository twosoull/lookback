package com.lookback.domain.user.repository;

import com.lookback.domain.user.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    List<Users> findAll();

    List<Users> findStudentsByTrainerOrderByUserNameAsc(Long trainerId);

    List<Users> findStudentsByTrainerOrderByRecentDesc(Long trainerId);

    List<Users> findStudentsByTrainerAndUserNameOrderByUserNameAsc(Long trainerId, String userName);

    Users findById(Long usersId);

    Users findByEmail(String email);

    Users save(Users users);

    Optional<Users> findByKakaoId(String kakaoId);
}
