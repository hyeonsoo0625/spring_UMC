package com.example.UMC_spring.converter;

import com.example.UMC_spring.web.domain.Review;

public class StoreConverter {

    public static Review toReview(StoreRequestDTO.ReviewDTO request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }
    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return null;
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(List<Review> reviewList){
        return null;
    }
}
