package com.booking.controller;

import com.booking.common.Response;
import com.booking.exception.ExceptionControllerHandle;
import com.booking.payload.request.ForgotRequest;
import com.booking.payload.request.ResetPasswordRequest;
import com.booking.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users-forgot")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ForgotController extends ExceptionControllerHandle {
    @Autowired
    UserService userService;

    @PostMapping("/forgot")
    public ResponseEntity<?> forgot(@RequestBody ForgotRequest forgotRequest) {
        userService.forgotPassword(forgotRequest.getEmail());
        return ResponseEntity.ok(Response.success("Please check your mail, your token is sent", null));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> forgot(@RequestBody ResetPasswordRequest request) {
        String message = userService.resetPassword(request);
        return ResponseEntity.ok(Response.success(message, null));
    }
}
