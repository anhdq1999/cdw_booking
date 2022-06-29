package com.booking.controller;

import com.booking.common.Response;
import com.booking.converter.ReviewConverter;
import com.booking.entity.ReviewEntity;
import com.booking.payload.request.ReviewRequest;
import com.booking.payload.response.ReviewResponse;
import com.booking.services.impl.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<ReviewResponse> reviews = reviewService.getAll().stream()
                .map(review-> ReviewConverter.toResponse(review))
                .collect(Collectors.toList());
        return ResponseEntity.ok(Response.success("Get all reviews successfully",reviews));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody ReviewRequest reviewRequest){
        try {
            reviewService.update(id, reviewRequest);
            return ResponseEntity.ok(Response.success("Update review with id:"+id+" successfully",null));
        }catch (IllegalArgumentException e){
            return ResponseEntity.internalServerError().body(Response.fail(e.getMessage()));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            reviewService.deleteById(id);
            return ResponseEntity.ok(Response.success("Delete review with id:"+id+" successfully",null));
        }catch (IllegalArgumentException e){
            return ResponseEntity.internalServerError().body(Response.fail(e.getMessage()));
        }
    }


}
