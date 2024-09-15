package com.JobApplication.Review;

import com.JobApplication.Company.Company;
import com.JobApplication.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;



    public ReviewServiceImp(ReviewRepository reviewRepository,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReview(int companyId) {
        List<Review> review=reviewRepository.findByCompanyId(companyId);
        return review;
    }

    @Override
    public boolean addReview(int companyId, Review review) {
        Company company=companyService.findCompanyId(companyId);
        if(company!=null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }return false;
    }

    @Override
    public Review getReviewById(int reviewId, int companyId) {
       List<Review> review=reviewRepository.findByCompanyId(companyId);
       for(Review reviewSpecific:review){
           if(reviewSpecific.getId()==reviewId)
               return reviewSpecific;
       }return null;
    }

    @Override
    public boolean deleteReviewById(int reviewId, int companyId) {
        List<Review> review=reviewRepository.findByCompanyId(companyId);
        for(Review findReview:review){
            if(findReview.getId()==reviewId){
                reviewRepository.deleteById(reviewId);
                return true;
            }
        }return false;
    }

    @Override
    public boolean updateReviewById(int reviewId, int companyId,Review review) {
        List<Review> oldReview=reviewRepository.findByCompanyId(companyId);
        for(Review findReview:oldReview){
            if(findReview.getId()==reviewId){
                findReview.setTitle(review.getTitle());
                findReview.setDescription(review.getDescription());
                findReview.setRating(review.getRating());
                reviewRepository.save(findReview);
                return true;
            }
        }return false;
    }
}
