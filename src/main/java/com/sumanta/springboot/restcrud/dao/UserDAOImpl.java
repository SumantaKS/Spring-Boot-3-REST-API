package com.sumanta.springboot.restcrud.dao;

import com.sumanta.springboot.restcrud.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByUserName(String userName) {

        TypedQuery<User> theQuery = entityManager.createQuery("FROM User WHERE userName=:username AND enabled=true", User.class);
        theQuery.setParameter("username", userName);

        User user = null;

        try{
            user = theQuery.getSingleResult();
        } catch (Exception e){
            user = null;
        }

        return  user;
    }
}
