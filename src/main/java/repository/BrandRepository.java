package repository;

import model.Brand;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRepository {

    private final Connection connection;

    public BrandRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean saveBrand(Brand brand) throws SQLException {

        String addBrand = "INSERT INTO maktab.hw8.brand (brand_name, website, description) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addBrand);

        preparedStatement.setString(1, brand.getBrandName());
        preparedStatement.setString(2, brand.getWebsite());
        preparedStatement.setString(3, brand.getDescription());
        int resultSet = preparedStatement.executeUpdate();

        return (resultSet == 1) ? true : false;
    }

    public Brand findByBrandId(int brandId) throws SQLException {

        String findBrand = "SELECT * FROM maktab.hw8.brand WHERE brand_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findBrand);
        preparedStatement.setInt(1, brandId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("brand_id");
            String brandName = resultSet.getString("brand_name");
            String website = resultSet.getString("website");
            String description = resultSet.getString("description");
            Brand brand = new Brand(id, brandName, website, description);
            return brand;
        } else
            return null;
    }

    public Brand[] getAllBrands() {
        Brand[] brands = null;

        try {
            String findCountBrand = "SELECT COUNT(*) FROM maktab.hw8.brand";
            PreparedStatement preparedStatement = connection.prepareStatement(findCountBrand);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int rowCount = resultSet.getInt(1);
                brands = new Brand[rowCount];
            }
            String findBrand = "SELECT * FROM maktab.hw8.brand";
            preparedStatement = connection.prepareStatement(findBrand);
            resultSet = preparedStatement.executeQuery();

            int index = 0;
            while (resultSet.next()) {
                int brandId = resultSet.getInt("brand_id");
                String brandName = resultSet.getString("brand_name");
                String website = resultSet.getString("website");
                String description = resultSet.getString("description");

                Brand brand = new Brand(brandId, brandName, website, description);
                brands[index] = brand;
                index++;
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brands;
    }

    public boolean update(Brand brand) throws SQLException {
        String updateBrand = "UPDATE maktab.hw8.brand SET brand_name = ?, website = ? , description = ? WHERE brand_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateBrand);

        preparedStatement.setString(1, brand.getBrandName());
        preparedStatement.setString(2, brand.getWebsite());
        preparedStatement.setString(3, brand.getDescription());
        preparedStatement.setInt(4, brand.getBrandId());
        int rowsUpdated = preparedStatement.executeUpdate();
        return (rowsUpdated == 1) ? true : false;
    }

    public boolean deleteBrandById(int brandId) throws SQLException {
        String deleteBrand = "DELETE FROM maktab.hw8.brand  WHERE brand_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteBrand);
        preparedStatement.setInt(1, brandId);
        int rowsUpdated = preparedStatement.executeUpdate();
        return (rowsUpdated == 1) ? true : false;
    }
}

