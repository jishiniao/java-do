package com.jishiniao.jms1.repository;

import com.jishiniao.jms1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameContaining(String keyword);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.email = :email WHERE u.id = :id")
    int updateNameById(@Param("email") String email, @Param("id") Long id);

    User findByEmail(String email);

    User deleteByEmail(String email);

    Optional<User> findById(long id);

}
