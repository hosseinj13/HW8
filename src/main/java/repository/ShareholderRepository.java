package repository;

import model.Brand;
import model.Category;
import model.Product;
import model.Shareholder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ShareholderRepository {

    private final Connection connection;
    public ShareholderRepository(Connection connection){
        this.connection = connection;
    }


    public boolean addShareholder(Shareholder shareholder) throws SQLException {

        String addShareholder = "INSERT INTO maktab.hw8.shareholder (shareholder_name, phone_number, national_code) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addShareholder);

        preparedStatement.setString(1, shareholder.getShareholderName());
        preparedStatement.setString(2,  shareholder.getPhoneNumber());
        preparedStatement.setString(3, shareholder.getNationalCode());
        int resultSet = preparedStatement.executeUpdate();

        return (resultSet == 1) ? true : false;
    }

    public Shareholder findByShareholderId(int shareholderId) throws SQLException {

        String findShareholder = "SELECT * FROM maktab.hw8.shareholder WHERE shareholder_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findShareholder);
        preparedStatement.setInt(1, shareholderId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("shareholder_id");
            String shareholderName = resultSet.getString("shareholder_name");
            String phoneNumber = resultSet.getString("phone_number");
            String nationalCode = resultSet.getString("national_code");
            Shareholder shareholder = new Shareholder(id, shareholderName, phoneNumber, nationalCode);
            return shareholder;
        } else
            return null;
    }


    public Shareholder[] getAllShareholder() {
        Shareholder[] shareholders = null;

        try {
            String findCountShareholder = "SELECT COUNT(*) FROM maktab.hw8.shareholder";
            PreparedStatement preparedStatement = connection.prepareStatement(findCountShareholder);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int rowCount = resultSet.getInt(1);
                shareholders = new Shareholder[rowCount];
            }
            String findShareholder = "SELECT * FROM maktab.hw8.shareholder";
            preparedStatement = connection.prepareStatement(findShareholder);
            resultSet = preparedStatement.executeQuery();

            int index = 0;
            while (resultSet.next()) {
                int shareholderId = resultSet.getInt("shareholder_id");
                String shareholderName = resultSet.getString("shareholder_name");
                String phoneNumber = resultSet.getString("phone_number");
                String nationalCode = resultSet.getString("national_code");


                Shareholder shareholder = new Shareholder(shareholderId, shareholderName, phoneNumber, nationalCode);
                shareholders[index] = shareholder;
                index++;
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shareholders;
    }


    public boolean update(Shareholder shareholder) throws SQLException {
        String updateShareholder = "UPDATE maktab.hw8.shareholder SET shareholder_name = ?, phone_number = ?, national_code = ?  WHERE shareholder_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateShareholder);

        preparedStatement.setString(1, shareholder.getShareholderName());
        preparedStatement.setString(2, shareholder.getPhoneNumber());
        preparedStatement.setString(3, shareholder.getNationalCode());
        preparedStatement.setInt(4, shareholder.getShareholderId());
        int rowsUpdated = preparedStatement.executeUpdate();

        return (rowsUpdated == 1) ? true : false;
    }

    public boolean deleteShareholderById(int shareholderId) throws SQLException {
        String deleteShareholder = "DELETE FROM maktab.hw8.shareholder  WHERE shareholder_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteShareholder);
        preparedStatement.setInt(1, shareholderId);
        int rowsUpdated = preparedStatement.executeUpdate();
        return (rowsUpdated == 1) ? true : false;
    }

}
