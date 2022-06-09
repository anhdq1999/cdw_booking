package com.example.cdweb.HotelBookingAPI.controller;

import com.example.cdweb.HotelBookingAPI.config.Response;
import com.example.cdweb.HotelBookingAPI.converter.RoleConverter;
import com.example.cdweb.HotelBookingAPI.entity.Role;
import com.example.cdweb.HotelBookingAPI.payload.request.RoleRequest;
import com.example.cdweb.HotelBookingAPI.payload.response.RoleResponse;
import com.example.cdweb.HotelBookingAPI.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<RoleResponse> roleResponseList= roleService.getAll().stream().map(role -> RoleConverter.getInstance().toResponse(role))
                .collect(Collectors.toList());
        return ResponseEntity.ok(Response.success("Get all role successfully",roleResponseList));
    }
    @PostMapping
    public ResponseEntity<?> createRole(@RequestBody Role role){

        if(roleService.addRole(role)){
            RoleResponse roleResponse=RoleConverter.getInstance().toResponse(role);
            return ResponseEntity.ok(Response.success("Create role successfully",roleResponse));
        }else{
            return ResponseEntity.internalServerError().body(Response.fail("Fail"));
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRole(@PathVariable Long id,@RequestBody RoleRequest roleRequest){
        try {
            Role role = roleService.updateRole(id, roleRequest);
            RoleResponse roleResponse=RoleConverter.getInstance().toResponse(role);
            return ResponseEntity.ok(Response.success("Update role successfully",roleResponse));
        }catch (IllegalArgumentException e){
            return ResponseEntity.ok(Response.fail(e.getMessage()));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable("id") Long id){
        if(roleService.deleteRole(id)){
            return ResponseEntity.ok(Response.success("Delete role with id "+id +" successfully",null));
        }else{
            return ResponseEntity.internalServerError().body("xảy ra lỗi");
        }
    }
}
