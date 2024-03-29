package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.UserProfile;
import com.bilgeadam.repository.enums.EStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends MongoRepository<UserProfile, String> {

    Boolean existsByUsername(String username);

    Optional<UserProfile> findByAuthId(Long authId);

    Optional<UserProfile> findByUsername(String username);

    List<UserProfile> findByStatus(EStatus status);

    @Query("{username: ?0,email: ?1}")
    Optional<UserProfile> getUser(String username, String email);

    @Query("{authId: {$gt: ?0}}")
    Optional<UserProfile> findUserGtId(Long authId);

    @Query("{$or: [{authId:{$gt: ?0}},{status: ?1}]}")
    Optional<UserProfile> getUserGtIdAndStatus(Long authId, EStatus status);

    @Query("{status: 'ACTIVE'}")
    Optional<UserProfile> findActiveProfile();
}