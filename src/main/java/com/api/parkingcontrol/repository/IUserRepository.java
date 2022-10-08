package com.api.parkingcontrol.repository;

import com.api.parkingcontrol.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findByUserName(String userName);
}
