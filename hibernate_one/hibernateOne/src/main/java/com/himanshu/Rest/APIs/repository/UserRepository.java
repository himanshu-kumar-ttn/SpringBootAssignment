package com.himanshu.Rest.APIs.repository;

import com.himanshu.Rest.APIs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
