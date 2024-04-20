package app.FoodView;

@Entity
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;

    public Object getName() {
    }

    public void setName(Object name) {
    }

    public Object getDescription() {
    }

    public void setDescription(Object description) {
    }

    public Object getImageUrl() {
    }

    public void setImageUrl(Object imageUrl) {
    }

    // Getters and setters
}
