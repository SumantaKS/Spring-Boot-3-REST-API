package com.sumanta.springboot.restcrud.dao;

import com.sumanta.springboot.restcrud.entity.Role;

public interface RoleDAO {

    public Role findRoleByName(String roleName);

}
