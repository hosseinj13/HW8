package service;

import model.Brand;
import model.Shareholder;
import model.ShareholderBrand;
import repository.ProductRepository;
import repository.ShareholderBrandRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderBrandService {

    private final ShareholderBrandRepository shareholderBrandRepository;

    private final Scanner scanner = new Scanner(System.in);


    public ShareholderBrandService(ShareholderBrandRepository shareholderBrandRepository) {
        this.shareholderBrandRepository = shareholderBrandRepository;
    }

    public void saveShareholderBrand() throws SQLException {
        System.out.println("Please enter shareholder id :  ");
        int shareholderId = scanner.nextInt();
        System.out.println("Please enter brand id :  ");
        int brandId = scanner.nextInt();


        ShareholderBrand shareholderBrand = new ShareholderBrand(shareholderId, brandId);

        boolean insert = shareholderBrandRepository.addShareholderBrand(shareholderBrand);
        System.out.println((insert == true) ? "insert ShareholderBrand done" : "insert not valid");
    }

    public void findَAllShareholdersBrands() throws SQLException {
        System.out.println("Please show all shareholder id and name :  ");
        ShareholderBrand[] shareholderBrands = shareholderBrandRepository.getAllShareholderBrand();
        if (shareholderBrands != null) {
            for (ShareholderBrand shareholderBrand : shareholderBrands) {
                System.out.println("Shareholder ID: " + shareholderBrand.getShareholderId() + ", Brand ID: " + shareholderBrand.getBrandId());
                //System.out.println(shareholder);
            }
        } else {
            System.out.println("Failed to retrieve shareholderBrands.");
        }
    }

    public void findShareholderBrand() throws SQLException {
        System.out.println("Please enter shareholder Id :  ");
        int shareholderId = scanner.nextInt();

        ShareholderBrand existingShareholderBrand = shareholderBrandRepository.findByShareholderId(shareholderId);
        if (existingShareholderBrand == null) {
            System.out.println("Brand with ID " + shareholderId + " not found.");
            return;
        }
        System.out.println("Current ShareholderBrand Information:");
        System.out.println(existingShareholderBrand);
    }

    public void updateShareholderBrand() throws SQLException {
        System.out.println("Please enter shareholder id for update  :  ");
        int shareholderId = scanner.nextInt();

        ShareholderBrand existingShareholderBrand = shareholderBrandRepository.findByShareholderId(shareholderId);
        if (existingShareholderBrand == null) {
            System.out.println("Shareholder with ID " + shareholderId + " not found.");
            return;
        }

        System.out.println("Current ShareholderBrand Information:");
        System.out.println(existingShareholderBrand);

        System.out.println("Please enter brand id for update  :  ");
        int newBrandId = scanner.nextInt();

        ShareholderBrand shareholderBrand = new ShareholderBrand(shareholderId, newBrandId);
        boolean rowsUpdated = shareholderBrandRepository.update(shareholderBrand);

        if (rowsUpdated) {
            System.out.println("The ShareholderBrand has been updated successfully.");
        } else {
            System.out.println("No changes were made, or an error occurred during the update.");
        }
    }

    public void deleteShareholderBrand() throws SQLException {
        System.out.println("Please enter shareholder id for delete  :  ");
        int shareholderId = scanner.nextInt();

        boolean rowsUpdated = shareholderBrandRepository.deleteShareholderBrandById(shareholderId);

        if (rowsUpdated) {
            System.out.println("The ShareholderBrand has been deleted successfully.");
        } else {
            System.out.println("No shareholder with this ID were found for delete.");
        }
    }

}
