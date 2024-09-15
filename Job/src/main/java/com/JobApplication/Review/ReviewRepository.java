package com.JobApplication.Review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    List<Review> findByCompanyId(int companyId);
    //select * from review where companyid=?;
    //reviewRepository.findByCompany(1)
    //? replaced by 1
}
