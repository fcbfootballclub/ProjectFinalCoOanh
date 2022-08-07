package com.example.final_v1.Role.Controller;

import com.example.final_v1.ErrorHandler.ResponseObj;
import com.example.final_v1.Role.Model.Role;
import com.example.final_v1.Role.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "role")
@CrossOrigin(origins = "http://localhost:3000/")

public class RoleController {
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(path = "")
    ResponseObj getAllRole(){
        return new ResponseObj("OK", "Success", roleService.getAllRole());
    }

    @GetMapping(path = "{id}")
    ResponseObj getRoleById(@PathVariable long id){
        Optional<Role> found = roleService.getRoleById(id);
        return found.map(s -> new ResponseObj("OK", "Found role", found.get())).orElseGet(() -> new ResponseObj("Failed", "Not found id" + id, ""));
    }

    @PostMapping(path = "")
    ResponseObj addNewRole(@RequestBody Role role){
        int check = roleService.addNewRole(role);
        if(check == 1){
            return new ResponseObj("OK", "Success", role);
        }
        return new ResponseObj("Failed", "Not success", role);
    }

    @PutMapping(path = "{id}")
    ResponseObj updateRole(@PathVariable long id, @RequestBody Role role){
        int i = roleService.updateRole(id, role);
        if(i == 1){
            return new ResponseObj("OK","Update success", role);
        }
        return new ResponseObj("Failed", "Update fail", role);
    }

    @DeleteMapping(path = "{id}")
    ResponseObj deleteRole(@PathVariable long id){
        int i = roleService.deleteRole(id);
        if(i == 1){
            return new ResponseObj("OK", "Delete successfully", "");
        }
        return new ResponseObj("Failed", "Delete failed", "");
    }
}
