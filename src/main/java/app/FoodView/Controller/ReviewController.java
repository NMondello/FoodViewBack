package app.FoodView.Controller;

import app.FoodView.Review;
import app.FoodView.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// ReviewController.java
@RestController
@RequestMapping("/api/review")
@CrossOrigin(origins = "http://localhost:3000") // Apply CORS configuration to the entire controller
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/")
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        return reviewOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        try{
            Review savedReview = reviewRepository.save(review);
            return ResponseEntity.ok(savedReview);
        }catch (Exception e) {
            // Log the error for debugging purposes
            e.printStackTrace();
            // Return a 500 Internal Server Error with a descriptive error message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            Review existingReview = reviewOptional.get();
            existingReview.setRating(updatedReview.getRating());
            existingReview.setComment(updatedReview.getComment());
            Review savedReview = reviewRepository.save(existingReview);
            return ResponseEntity.ok(savedReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
