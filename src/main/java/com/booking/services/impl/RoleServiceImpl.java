package com.booking.services.impl;

import com.booking.converter.RoleConverter;
import com.booking.entity.ERole;
import com.booking.entity.Role;
import com.booking.payload.request.RoleRequest;
import com.booking.payload.response.RoleResponse;
import com.booking.repository.RoleRepository;
import com.booking.services.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final RoleRepository roleRepository;
    private RoleConverter roleConverter;

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public boolean addRole(Role role) {
        try {
            roleRepository.save(role);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Role updateRole(Long id, RoleRequest roleRequest) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Role with " + id + " not found"));
        Role roleUpdate = RoleConverter.getInstance().toEntity(roleRequest);
        roleUpdate.setId(role.getId());
        return roleRepository.save(roleUpdate);

    }

    public boolean deleteRole(Long id) {
        try {
            roleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        List<Role> listRoles = roleRepository.findAll();

        return null;
    }

    @Override
    public RoleResponse findById(Long id) {
        return null;
    }

    @Override
    public RoleResponse save(RoleRequest roleRequest) {
        return null;
    }

    @Override
    public void save(Role roleRequest) {
        roleRepository.save(roleRequest);
    }

    @Override
    public RoleResponse edit(Long id, RoleRequest roleRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Role> findByName(ERole name) {
        return roleRepository.findByName(name);
    }
}
