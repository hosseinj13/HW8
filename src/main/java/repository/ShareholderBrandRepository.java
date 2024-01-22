package repository;

import model.Shareholder;
import model.ShareholderBrand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShareholderBrandRepository {

    private final Connection connection;

    public ShareholderBrandRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean addShareholderBrand(ShareholderBrand shareholderBrand) throws SQLException {

        String addShareholderBrand = "INSERT INTO maktab.hw8.shareholder_brand (shareholder_id, brand_id) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addShareholderBrand);

        preparedStatement.setInt(1, shareholderBrand.getShareholderId());
        preparedStatement.setInt(2, shareholderBrand.getBrandId());
        int resultSet = preparedStatement.executeUpdate();

        return (resultSet == 1) ? true : false;
    }


    public ShareholderBrand findByShareholderId(int shareholderId) throws SQLException {

        String findShareholderBrand = "SELECT * FROM maktab.hw8.shareholder_brand WHERE shareholder_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findShareholderBrand);
        preparedStatement.setInt(1, shareholderId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("shareholder_id");
            int brandId = resultSet.getInt("brand_id");
            ShareholderBrand shareholderBrand = new ShareholderBrand(id, brandId);
            return shareholderBrand;
        } else
            return null;
    }

    public ShareholderBrand[] getAllShareholderBrand() {
        ShareholderBrand[] shareholderBrands = null;

        try {
            String findCountShareholderBrand = "SELECT COUNT(*) FROM maktab.hw8.shareholder_brand";
            PreparedStatement preparedStatement = connection.prepareStatement(findCountShareholderBrand);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int rowCount = resultSet.getInt(1);
                shareholderBrands = new ShareholderBrand[rowCount];
            }
            String findShareholderBrand = "SELECT * FROM maktab.hw8.shareholder_brand";
            preparedStatement = connection.prepareStatement(findShareholderBrand);
            resultSet = preparedStatement.executeQuery();

            int index = 0;
            while (resultSet.next()) {
                int shareholderId = resultSet.getInt("shareholder_id");
                int brandId = resultSet.getInt("brand_id");


                ShareholderBrand shareholderBrand = new ShareholderBrand(shareholderId, brandId);
                shareholderBrands[index] = shareholderBrand;
                index++;
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shareholderBrands;
    }


    public boolean update(ShareholderBrand shareholderBrand) throws SQLException {
        String updateShareholderBrand = "UPDATE maktab.hw8.shareholder_brand SET  brand_id = ? WHERE shareholder_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateShareholderBrand);

        preparedStatement.setInt(1, shareholderBrand.getBrandId());
        preparedStatement.setInt(2, shareholderBrand.getShareholderId());
        int rowsUpdated = preparedStatement.executeUpdate();

        return (rowsUpdated == 1) ? true : false;
    }

    public boolean deleteShareholderBrandById(int shareholderId) throws SQLException {
        String deleteShareholderBrand = "DELETE FROM maktab.hw8.shareholder_brand  WHERE shareholder_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteShareholderBrand);
        preparedStatement.setInt(1, shareholderId);
        int rowsUpdated = preparedStatement.executeUpdate();
        return (rowsUpdated == 1) ? true : false;
    }
}
