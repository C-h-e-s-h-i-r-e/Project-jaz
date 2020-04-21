package pl.edu.pjwstk.jaz.auction;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.*;
import java.util.List;

@Named
@RequestScoped
public class AuctionRequest {
    @NotNull
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$")
    private String title;
    @NotNull
    private String description;
    @NotNull
    private Float price;
    private String categoryName;
    private List<String> photosUrls;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<String> getPhotosUrls() {
        return photosUrls;
    }

    public void setPhotosUrls(List<String> photosUrls) {
        this.photosUrls = photosUrls;
    }
}
