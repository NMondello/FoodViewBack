package app.FoodView;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long foodItemId;
    private String username;
    private int rating;
    private String comment;

    public Object getRating() {
    }

    public void setRating(Object rating) {
    }

    public Object getComment() {
    }

    public void setComment(Object comment) {
    }

    // Getters and setters
}