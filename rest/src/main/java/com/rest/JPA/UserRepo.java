package com.rest.JPA;

import com.rest.entity.UserList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserList,Integer>{
   Optional<UserList> findByName(String username);

}
