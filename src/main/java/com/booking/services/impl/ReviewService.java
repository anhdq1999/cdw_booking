package com.booking.services.impl;

import com.booking.converter.ReviewConverter;
import com.booking.entity.ReviewEntity;
import com.booking.entity.RoomEntity;
import com.booking.payload.request.ReviewRequest;
import com.booking.payload.response.ReviewResponse;
import com.booking.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<ReviewEntity> getAll(){
        return reviewRepository.findAll();
    }
    public ReviewEntity save(ReviewRequest reviewRequest,RoomEntity room){
        ReviewEntity review = ReviewConverter.toEntity(reviewRequest);
        review.setRoom(room);
        return reviewRepository.save(review);
    }

    public void update(Long id,ReviewRequest reviewRequest){
        ReviewEntity review =ReviewConverter.toEntity(reviewRequest);
        Optional<ReviewEntity> optionalReview=reviewRepository.findById(id);
        if(optionalReview.isPresent()){
            review.setId(id);
            reviewRepository.save(review);
        }
    }
    public void delete(Long id){
        reviewRepository.deleteById(id);
    }
    public ReviewEntity getById(Long id){
        Optional<ReviewEntity> optionalReview=reviewRepository.findById(id);
        if(optionalReview.isPresent()) return optionalReview.get();
        return null;
    }
    public List<ReviewEntity> saveAll(List<ReviewRequest> requests, RoomEntity room){
        List<ReviewEntity> reviews = requests.stream().map(review ->{
           ReviewEntity entity= ReviewConverter.toEntity(review);
           entity.setRoom(room);
           return entity;
        }).collect(Collectors.toList());
       return reviewRepository.saveAll(reviews);
    }
}
