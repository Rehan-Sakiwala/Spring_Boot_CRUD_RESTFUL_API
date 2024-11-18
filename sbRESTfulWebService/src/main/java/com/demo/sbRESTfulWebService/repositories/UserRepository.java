package com.demo.sbRESTfulWebService.repositories;

import com.demo.sbRESTfulWebService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    //CRUD operations methods will be inherited by this interface

}
