package app.FoodView;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAll();

    Optional<Review> findById(Long id);

    Review save(Review review);

    void deleteById(Long id);
}