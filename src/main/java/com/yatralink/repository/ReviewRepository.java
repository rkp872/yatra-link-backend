package com.yatralink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yatralink.model.Destination;
import com.yatralink.model.Review;
import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByDestination(Destination destination);
}
