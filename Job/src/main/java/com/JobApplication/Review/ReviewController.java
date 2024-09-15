package com.JobApplication.Review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview(@PathVariable int companyId){
        return new ResponseEntity<>(reviewService.getAllReview(companyId), HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> addReviews(@PathVariable int companyId,@RequestBody Review review){
        if(reviewService.addReview(companyId,review))
            return new ResponseEntity<>("Review Added",HttpStatus.OK);
        return new ResponseEntity<>("Company not Exist", HttpStatus.NOT_FOUND);
    }
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable int reviewId,@PathVariable int companyId){
        Review review =reviewService.getReviewById(reviewId,companyId);
        if(review!=null)
            return new ResponseEntity<>(review,HttpStatus.OK);
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable int reviewId,@PathVariable int companyId){
        if(reviewService.deleteReviewById(reviewId,companyId))
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        return new ResponseEntity<>("Review Not Found", HttpStatus.NOT_FOUND);

    }
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable int reviewId,@PathVariable int companyId,@RequestBody Review review){
        if(reviewService.updateReviewById(reviewId,companyId,review))
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        return new ResponseEntity<>("review not found",HttpStatus.NOT_FOUND);
    }
}
