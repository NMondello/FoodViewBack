package app.FoodView.Controller;

import app.FoodView.FoodItem;
import app.FoodView.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// FoodController.java
@RestController
@RequestMapping("/api/food")
public class FoodController {
    @Autowired
    private FoodItemRepository foodItemRepository;

    @GetMapping("/")
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long id) {
        Optional<FoodItem> foodItemOptional = foodItemRepository.findById(id);
        return foodItemOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<FoodItem> createFoodItem(@RequestBody FoodItem foodItem) {
        FoodItem savedFoodItem = foodItemRepository.save(foodItem);
        return ResponseEntity.ok(savedFoodItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> updateFoodItem(@PathVariable Long id, @RequestBody FoodItem updatedFoodItem) {
        Optional<FoodItem> foodItemOptional = foodItemRepository.findById(id);
        if (foodItemOptional.isPresent()) {
            FoodItem existingFoodItem = foodItemOptional.get();
            existingFoodItem.setName(updatedFoodItem.getName());
            existingFoodItem.setDescription(updatedFoodItem.getDescription());
            existingFoodItem.setImageUrl(updatedFoodItem.getImageUrl());
            FoodItem savedFoodItem = foodItemRepository.save(existingFoodItem);
            return ResponseEntity.ok(savedFoodItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable Long id) {
        foodItemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
