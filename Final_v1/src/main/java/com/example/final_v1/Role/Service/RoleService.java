package com.example.final_v1.Role.Service;

import com.example.final_v1.Role.Model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    public List<Role> getAllRole();
    public Optional<Role> getRoleById(long id);
    public int addNewRole(Role role);
    public int updateRole(long id, Role role);
    public int deleteRole(long id);
}
