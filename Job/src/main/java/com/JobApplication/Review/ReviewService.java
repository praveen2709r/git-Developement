package com.JobApplication.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReview(int companyId);

    boolean addReview(int companyId, Review review);

    Review getReviewById(int reviewId, int companyId);

    boolean deleteReviewById(int reviewId, int companyId);

    boolean updateReviewById(int reviewId, int companyId,Review review);
}
