package com.sumanta.springboot.restcrud.dao;

import com.sumanta.springboot.restcrud.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO{

    private EntityManager entityManager;

    @Autowired
    public RoleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Role findRoleByName(String roleName) {

        TypedQuery<Role> theQuery = entityManager.createQuery("FROM Role WHERE name=:roleName", Role.class);
        theQuery.setParameter("roleName", roleName);

        Role role = null;

        try{
            role = theQuery.getSingleResult();
        } catch (Exception e){
            role = null;
        }

        return role;
    }
}
