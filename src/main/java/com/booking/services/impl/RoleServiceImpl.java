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

    @Override
    public RoleEntity getById(Long id) {
        return null;
    }

    public RoleEntity save(RoleRequest roleRequest) {
        RoleEntity entity = RoleConverter.toEntity(roleRequest);
        return roleRepository.save(entity);

    }

    @Override
    public void save(RoleEntity roleEntityRequest) {
    }

    public RoleEntity update(Long id, RoleRequest roleRequest) {
        RoleEntity roleEntity = roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Role with " + id + " not found"));
        RoleEntity roleEntityUpdate = RoleConverter.toEntity(roleRequest);
        roleEntityUpdate.setId(roleEntity.getId());
        return roleRepository.save(roleEntityUpdate);

    }

    public boolean delete(Long id) {
        try {
            roleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<RoleEntity> findByName(ERole name) {
        return roleRepository.findByName(name);
    }
}
