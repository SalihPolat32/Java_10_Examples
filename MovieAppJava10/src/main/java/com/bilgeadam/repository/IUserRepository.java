package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.User;
import org.hibernate.usertype.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    List<User> findAllByEmailContainingIgnoreCase(String value);

    List<User> findAllByEmailEndingWith(String value);

    @Query("SELECT u FROM User AS u WHERE LENGTH(u.password) > ?1")
    List<User> passwordLongerThan(int value);

    @Query("SELECT u FROM User AS u WHERE LENGTH(u.password) > :x")
    List<User> passwordLongerThan2(@Param("x") int value);

    @Query(value = "SELECT * FROM tbl_user AS u WHERE LENGTH(u.password) > ?1", nativeQuery = true)
    List<User> passwordLongerThan3(int value);
}