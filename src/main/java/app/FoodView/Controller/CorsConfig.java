package app.FoodView.Controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Apply CORS configuration to all endpoints under "/api"
                .allowedOrigins("http://localhost:3000") // Specify allowed origin explicitly
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specified HTTP methods
                .allowCredentials(true) // Allow credentials
                .maxAge(3600); // Cache preflight requests for 3600 seconds
    }
}
