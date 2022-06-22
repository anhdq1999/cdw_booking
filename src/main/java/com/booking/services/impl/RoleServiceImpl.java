package com.booking.services.impl;

import com.booking.converter.RoleConverter;
import com.booking.entity.ERole;
import com.booking.entity.RoleEntity;
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

    public List<RoleEntity> getAll() {
        return roleRepository.findAll();
    }

    public boolean addRole(RoleEntity roleEntity) {
        try {
            roleRepository.save(roleEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public RoleEntity updateRole(Long id, RoleRequest roleRequest) {
        RoleEntity roleEntity = roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Role with " + id + " not found"));
        RoleEntity roleEntityUpdate = RoleConverter.getInstance().toEntity(roleRequest);
        roleEntityUpdate.setId(roleEntity.getId());
        return roleRepository.save(roleEntityUpdate);

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
        List<RoleEntity> listRoleEntities = roleRepository.findAll();

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
    public void save(RoleEntity roleEntityRequest) {
        roleRepository.save(roleEntityRequest);
    }

    @Override
    public RoleResponse edit(Long id, RoleRequest roleRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<RoleEntity> findByName(ERole name) {
        return roleRepository.findByName(name);
    }
}
