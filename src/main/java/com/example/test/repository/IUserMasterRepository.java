package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.modals.UserMaster;

@Repository
public interface IUserMasterRepository extends JpaRepository<UserMaster, Long>{

}
