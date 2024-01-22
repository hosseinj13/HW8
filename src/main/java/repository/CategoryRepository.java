package repository;

import model.Brand;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepository {
    private final Connection connection;
    public CategoryRepository(Connection connection){
        this.connection = connection;
    }

    public boolean saveCategory(Category category) throws SQLException {

        String addCategory = "INSERT INTO maktab.hw8.category (category_name, description) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addCategory);

        preparedStatement.setString(1, category.getCategoryName());
        preparedStatement.setString(2, category.getDescription());
        int resultSet = preparedStatement.executeUpdate();

        return (resultSet == 1) ? true : false;
    }

    public Category findByCategoryId(int categoryId) throws SQLException {

        String findCategory = "SELECT * FROM maktab.hw8.category WHERE category_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findCategory);
        preparedStatement.setInt(1, categoryId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("category_id");
            String categoryName = resultSet.getString("category_name");
            String description = resultSet.getString("description");
            Category category = new Category(id, categoryName, description);
            return category;
        } else
            return null;
    }

    public Category[] getAllCategories() {
        Category[] categories = null;

        try {
            String findCountCategories = "SELECT COUNT(*) FROM maktab.hw8.category";
            PreparedStatement preparedStatement = connection.prepareStatement(findCountCategories);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int rowCount = resultSet.getInt(1);
                categories = new Category[rowCount];
            }
            String findCategory = "SELECT * FROM maktab.hw8.category";
            preparedStatement = connection.prepareStatement(findCategory);
            resultSet = preparedStatement.executeQuery();

            int index = 0;
            while (resultSet.next()) {
                int categoryId = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("category_name");
                String description = resultSet.getString("description");

                Category category = new Category(categoryId, categoryName, description);
                categories[index] = category;
                index++;
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    public boolean update(Category category) throws SQLException {
        String updateCategory = "UPDATE maktab.hw8.category SET category_name = ?, description = ?  WHERE category_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateCategory);

        preparedStatement.setString(1, category.getCategoryName());
        preparedStatement.setString(2, category.getDescription());
        preparedStatement.setInt(3, category.getCategoryId());
        int rowsUpdated = preparedStatement.executeUpdate();
        return (rowsUpdated == 1) ? true : false;
    }

    public boolean deleteCategoryById(int categoryId) throws SQLException {
        String deleteCategory = "DELETE FROM maktab.hw8.category  WHERE category_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteCategory);
        preparedStatement.setInt(1, categoryId);
        int rowsUpdated = preparedStatement.executeUpdate();
        return (rowsUpdated == 1) ? true : false;
    }
}
