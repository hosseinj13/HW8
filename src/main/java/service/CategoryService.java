package service;

import model.Brand;
import model.Category;
import repository.CategoryRepository;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final Scanner scanner = new Scanner(System.in);


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory() throws SQLException {
        System.out.println("Please enter category name :  ");
        String name = scanner.nextLine();
        System.out.println("Please enter category description:  ");
        String description = scanner.nextLine();

        Category category = new Category(name, description);

        boolean insert = categoryRepository.saveCategory(category);
        System.out.println((insert == true) ? "Insert category successfully" : "Insert category unsuccessfully");
    }

    public void findَAllCategories() throws SQLException {
        System.out.println("Please show all category id and name :  ");
        Category[] categories = categoryRepository.getAllCategories();
        if (categories != null) {
            // Displaying the retrieved categories
            for (Category category : categories) {
                System.out.println("Category ID: " + category.getCategoryId() + ", Category Name: " + category.getCategoryName());
            }
        } else {
            System.out.println("Failed to retrieve categories.");
        }
    }

    public void findCategory() throws SQLException {
        System.out.println("Please enter category Id :  ");
        int categoryId = scanner.nextInt();

        Category existingCategory = categoryRepository.findByCategoryId(categoryId);
        if (existingCategory == null) {
            System.out.println("Category with ID " + categoryId + " not found.");
            return;
        }
        System.out.println("Current Category Information:");
        System.out.println(existingCategory);
    }

    public void updateCategory() throws SQLException {
        System.out.println("Please enter category id for update  :  ");
        int categoryId = scanner.nextInt();

        Category existingCategory = categoryRepository.findByCategoryId(categoryId);
        if (existingCategory == null) {
            System.out.println("Category with ID " + categoryId + " not found.");
            return;
        }

        System.out.println("Current Category Information:");
        System.out.println(existingCategory);

        System.out.println("Please update category name :  ");
        String newCategoryName = scanner.nextLine();
        System.out.println("Please update category description:  ");
        String newCategoryDescription = scanner.nextLine();

        Category category = new Category(categoryId, newCategoryName, newCategoryDescription);
        boolean rowsUpdated = categoryRepository.update(category);

        if (rowsUpdated) {
            System.out.println("The category has been updated successfully.");
        } else {
            System.out.println("No changes were made, or an error occurred during the update.");
        }
    }

    public void deleteCategory() throws SQLException {
        System.out.println("Please enter category id for delete  :  ");
        int categoryId = scanner.nextInt();

        boolean rowsUpdated = categoryRepository.deleteCategoryById(categoryId);

        if (rowsUpdated) {
            System.out.println("The category has been deleted successfully.");
        } else {
            System.out.println("Category with ID " + categoryId + " not found for delete.");
        }
    }
}
