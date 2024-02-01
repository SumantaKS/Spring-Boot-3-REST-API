package com.sumanta.springboot.restcrud.dao;


import com.sumanta.springboot.restcrud.entity.User;

public interface UserDAO {

    public User findByUserName(String userName);

}
