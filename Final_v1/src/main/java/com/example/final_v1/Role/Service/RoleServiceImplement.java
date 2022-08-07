package com.example.final_v1.Role.Service;

import com.example.final_v1.Role.Model.Role;
import com.example.final_v1.Role.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImplement implements RoleService{
    private RoleRepository roleRepository;
    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(long id){
        return roleRepository.findById(id);
    }

    @Override
    public int addNewRole(Role role) {
        List<Role> list = roleRepository.findAll();
        if(!list.contains(role)){
            roleRepository.save(role);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateRole(long id, Role role) {
        Optional<Role> found = roleRepository.findById(id);
        if(found.isPresent()){
            found.get().setRoleTitle(role.getRoleTitle());
            roleRepository.save(role);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteRole(long id) {
        Optional<Role> found = roleRepository.findById(id);
        if(found.isPresent()){
            roleRepository.delete(found.get());
            return 1;
        }
        return 0;
    }
}
