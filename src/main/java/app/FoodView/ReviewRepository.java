package app.FoodView;

import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Nonnull
    List<Review> findAll();
    @Nonnull
    Optional<Review> findById(@Nonnull Long id);
    @Nonnull <S extends Review> S save(@Nonnull S Review);
    void deleteById( @Nonnull Long id);
}