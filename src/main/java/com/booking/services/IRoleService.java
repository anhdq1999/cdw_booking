package com.booking.services;

import com.booking.entity.ERole;
import com.booking.entity.RoleEntity;
import com.booking.payload.request.RoleRequest;
import com.booking.payload.response.RoleResponse;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<RoleEntity> getAll();

    RoleEntity getById(Long id);

    RoleEntity save(RoleRequest roleRequest);

    RoleEntity update(Long id, RoleRequest roleRequest);

    boolean delete(Long id);

    Optional<RoleEntity> findByName(ERole name);
}
