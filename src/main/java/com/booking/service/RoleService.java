package com.booking.service;

import com.booking.repository.RoleRepository;
import com.booking.converter.RoleConverter;
import com.booking.entity.Role;
import com.booking.payload.request.RoleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public boolean addRole(Role role){
        try{
            roleRepository.save(role);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Role updateRole(Long id, RoleRequest roleRequest){
            Role role =roleRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Role with "+id+" not found"));
            Role roleUpdate= RoleConverter.getInstance().toEntity(roleRequest);
            roleUpdate.setId(role.getId());
            return roleRepository.save(roleUpdate);

    }

    public boolean deleteRole(Long id){
        try{
            roleRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    }
