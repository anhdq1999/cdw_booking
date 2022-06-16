package com.booking.service;

import com.booking.payload.request.RoleRequest;
import com.booking.payload.response.RoleResponse;

import java.util.List;

public interface IRoleService {
    List<RoleResponse> getAllRoles();

    RoleResponse findById(Long id);

    RoleResponse save(RoleRequest roleRequest);

    RoleResponse edit(Long id, RoleRequest roleRequest);

    void delete(Long id);
}
