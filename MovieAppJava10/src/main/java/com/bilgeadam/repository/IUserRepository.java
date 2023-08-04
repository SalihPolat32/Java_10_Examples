package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.User;
import org.hibernate.usertype.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    // "SELECT * FROM user AS u WHERE u.email = ?1 AND u.password = ?2"

    Optional<User> findByEmailAndPassword(String email, String password);

    Boolean existsByPasswordAndEmail(String password, String email);

    List<User> findAllByUserType(UserType userType);

    List<User> findAllByOrderByName();

    List<User> findAllByOrderByNameDesc();

    List<User> findAllByNameContainingIgnoreCase(String value);
}