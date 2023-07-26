package lt.neskelbiu.java.main.poster;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.neskelbiu.java.main.poster.categories.CategoryA;
import lt.neskelbiu.java.main.poster.categories.CategoryB;
import lt.neskelbiu.java.main.user.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PosterRequest {
    private Long id;
    private String postName;
    private CategoryA categoryA;
    private CategoryB categoryB;
    private String description;
    private Status status;
    private Long userId;
    private Long phoneNumber;
    private City city;
    private String website;
    private String videoLink;

}