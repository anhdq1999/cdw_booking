package com.booking.services;

import com.booking.entity.ERole;
import com.booking.entity.RoleEntity;
import com.booking.payload.request.RoleRequest;
import com.booking.payload.response.RoleResponse;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<RoleResponse> getAllRoles();

    RoleResponse findById(Long id);

    RoleResponse save(RoleRequest roleRequest);

    void save(RoleEntity roleEntityRequest);

    RoleResponse edit(Long id, RoleRequest roleRequest);

    void delete(Long id);

    Optional<RoleEntity> findByName(ERole name);
}
