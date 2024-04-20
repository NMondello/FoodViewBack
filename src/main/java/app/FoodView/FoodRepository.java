package app.FoodView;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    List<FoodItem> findAll();

    Optional<FoodItem> findById(Long id);

    FoodItem save(FoodItem foodItem);

    void deleteById(Long id);
}