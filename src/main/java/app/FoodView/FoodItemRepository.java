package app.FoodView;

import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    @Nonnull List<FoodItem> findAll();

    @Nonnull Optional<FoodItem> findById(@Nonnull Long id);

    @Nonnull <S extends FoodItem> S save(@Nonnull S foodItem);

    void deleteById(@Nonnull Long id);
}