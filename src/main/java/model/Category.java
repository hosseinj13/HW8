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
}
