package service;

import model.Brand;
import model.Category;
import model.User;
import repository.BrandRepository;
import repository.UserRepository;
import utility.ApplicationContext;
import utility.EmailValidator;
import utility.PasswordValidator;
import utility.WebsiteValidator;

import java.sql.SQLException;
import java.util.Scanner;


public class BrandService {

    private final BrandRepository brandRepository;

    private static final BrandService brandService = ApplicationContext.getBrandService();


    private final Scanner scanner = new Scanner(System.in);


    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void addBrand() throws SQLException {
        System.out.println("Please enter brand name :  ");
        String name = scanner.nextLine();
        System.out.println("Please enter brand website:  ");
        String website = scanner.nextLine();
        if (WebsiteValidator.isWebsiteValid(website)) {
            System.out.println("Website URL is valid!");
        } else {
            System.out.println("Invalid website URL. Please enter a valid website URL.");
        }
        System.out.println("Please enter brand description:  ");
        String description = scanner.nextLine();

        if (WebsiteValidator.isWebsiteValid(website)) {
            Brand brand = new Brand(name, website, description);
            brandRepository.saveBrand(brand);
            System.out.println("insert done");
        } else {
            System.out.println("insert invalid!");
        }
    }

    public void findَAllBrands() throws SQLException {
        System.out.println("Please show all brand id and name :  ");
        Brand[] brands = brandRepository.getAllBrands();
        if (brands != null) {
            // Displaying the retrieved brands
            for (Brand brand : brands) {
                System.out.println("Brand ID: " + brand.getBrandId() + ", Brand Name: " + brand.getBrandName());
            }
        } else {
            System.out.println("Failed to retrieve brands.");
        }
    }

    public void findBrand() throws SQLException {
        System.out.println("Please enter brand Id :  ");
        int brandId = scanner.nextInt();

        Brand existingBrand = brandRepository.findByBrandId(brandId);
        if (existingBrand == null) {
            System.out.println("Brand with ID " + brandId + " not found.");
            return;
        }
        System.out.println("Current Brand Information:");
        System.out.println(existingBrand);
    }

    public void updateBrand() throws SQLException {
        System.out.println("Please enter brand id for update: ");
        int brandId = scanner.nextInt();

        Brand existingBrand = brandRepository.findByBrandId(brandId);
        if (existingBrand == null) {
            System.out.println("Brand with ID " + brandId + " not found.");
            return;
        }

        System.out.println("Current Brand Information:");
        System.out.println(existingBrand);

        System.out.println("Please update brand name: ");
        String newName = scanner.nextLine();

        System.out.println("Please update brand website: ");
        String newWebsite = scanner.nextLine();
        if (WebsiteValidator.isWebsiteValid(newWebsite)) {
            System.out.println("Invalid website URL. Please enter a valid website URL.");
            return;
        }

        System.out.println("Please update brand description: ");
        String newDescription = scanner.nextLine();

        Brand updatedBrand = new Brand(brandId, newName, newWebsite, newDescription);
        boolean isUpdated = brandRepository.update(updatedBrand);

        if (isUpdated) {
            System.out.println("The brand has been updated successfully.");
        } else {
            System.out.println("No changes were made, or an error occurred during the update.");
        }
    }


    public void deleteBrand() throws SQLException {
        System.out.println("Please enter brand id for delete  :  ");
        int brandId = scanner.nextInt();

        boolean rowsUpdated = brandRepository.deleteBrandById(brandId);

        if (rowsUpdated) {
            System.out.println("The brand has been deleted successfully.");
        } else {
            System.out.println("Brand with ID " + brandId + " not found for delete.");
        }
    }
}
