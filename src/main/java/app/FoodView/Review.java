package app.FoodView;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "food_item_id")
    private Long foodItemId;
    private int rating;
    private String comment;
    public Review() {
        // Default constructor is needed for JPA
    }

    // Constructor with parameters
    public Review(Long foodItemId, int rating, String comment) {
        this.foodItemId = foodItemId;
        this.rating = rating;
        this.comment = comment;
    }

    public long getFoodItemId() {
        return this.foodItemId;
    }
    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;
    }
    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // Getters and setters
}