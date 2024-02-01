package com.sumanta.springboot.restcrud.service;

import com.sumanta.springboot.restcrud.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

}
