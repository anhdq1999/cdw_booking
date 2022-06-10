package com.example.cdweb.HotelBookingAPI.service;

import com.example.cdweb.HotelBookingAPI.converter.RoleConverter;
import com.example.cdweb.HotelBookingAPI.entity.Role;
import com.example.cdweb.HotelBookingAPI.payload.request.RoleRequest;
import com.example.cdweb.HotelBookingAPI.payload.response.RoleResponse;
import com.example.cdweb.HotelBookingAPI.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
