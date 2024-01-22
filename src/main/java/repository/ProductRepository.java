package repository;

import model.Brand;
import model.Category;
import model.Product;

import java.sql.*;
import java.time.LocalDate;

public class ProductRepository {

    private final Connection connection;
    public ProductRepository(Connection connection){
        this.connection = connection;
    }

    public boolean saveProduct(Product product) throws SQLException {

        String addProduct = "INSERT INTO maktab.hw8.product (product_name, create_date, category_id, brand_id) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addProduct);

        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setDate(2, Date.valueOf((LocalDate) product.getCreateDate()));
        preparedStatement.setInt(3, product.getCategoryId().getCategoryId());
        preparedStatement.setInt(4, product.getBrandId().getBrandId());
        int resultSet = preparedStatement.executeUpdate();

        return (resultSet == 1) ? true : false;
    }

    public Product findByProductId(int productId) throws SQLException {

        String findProduct = "SELECT * FROM maktab.hw8.product WHERE product_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findProduct);
        preparedStatement.setInt(1, productId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("product_id");
            String productName = resultSet.getString("product_name");
            LocalDate createDate = resultSet.getDate("create_date").toLocalDate();
            int categoryId = resultSet.getInt("category_id");
            int brandId = resultSet.getInt("brand_id");

            Category category = new Category(categoryId);
            Brand brand = new Brand(brandId);

            Product product = new Product(id, productName, createDate, category, brand);
            return product;
        } else
            return null;
    }

    public Product[] getAllProducts() {
        Product[] products = null;

        try {
            String findCountProducts = "SELECT COUNT(*) FROM maktab.hw8.product";
            PreparedStatement preparedStatement = connection.prepareStatement(findCountProducts);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int rowCount = resultSet.getInt(1);
                products = new Product[rowCount];
            }
            String findProduct = "SELECT * FROM maktab.hw8.product";
            preparedStatement = connection.prepareStatement(findProduct);
            resultSet = preparedStatement.executeQuery();

            int index = 0;
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                LocalDate createDate = resultSet.getDate("create_date").toLocalDate();
                int categoryId = resultSet.getInt("category_id");
                int brandId = resultSet.getInt("brand_id");

                Category category = new Category(categoryId);
                Brand brand = new Brand(brandId);

                Product product = new Product(productId, productName, createDate, category, brand);
                products[index] = product;
                index++;
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public boolean update(Product product) throws SQLException {
        String updateProduct = "UPDATE maktab.hw8.product SET product_name = ?, create_date = ?, category_id = ?, brand_id = ?  WHERE product_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateProduct);

        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setDate(2, Date.valueOf((LocalDate) product.getCreateDate()));
        preparedStatement.setInt(3, product.getCategoryId().getCategoryId());
        preparedStatement.setInt(4, product.getBrandId().getBrandId());
        preparedStatement.setInt(5, product.getProductId());
        int rowsUpdated = preparedStatement.executeUpdate();

        return (rowsUpdated == 1) ? true : false;
    }

    public boolean deleteProductById(int productId) throws SQLException {
        String deleteProduct = "DELETE FROM maktab.hw8.product  WHERE product_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteProduct);
        preparedStatement.setInt(1, productId);
        int rowsUpdated = preparedStatement.executeUpdate();
        return (rowsUpdated == 1) ? true : false;
    }
}
