package com.booking.services;

import com.booking.entity.ReviewEntity;
import com.booking.payload.request.ReviewRequest;

import java.util.List;

public interface IReviewService {
     List<ReviewEntity> getAll();
     ReviewEntity save(ReviewRequest reviewRequest, Long roomId);
     ReviewEntity update(Long id,ReviewRequest reviewRequest);
     void deleteById(Long id);
     ReviewEntity getById(Long id);
     List<ReviewEntity> saveAllByRoom(List<ReviewRequest> requests, Long roomId);
}
