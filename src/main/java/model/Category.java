package model;

public class Category {
    private int categoryId;
    private String categoryName;
    private String description;

    public Category() {
    }

    public Category(int categoryId, String categoryName, String description) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
    }
}
