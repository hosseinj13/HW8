package model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Category {
    private int categoryId;
    private String categoryName;
    private String description;

    public Category(int categoryId) {
        this.categoryId = categoryId;
    }

    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }


}
