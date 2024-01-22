package service;

import model.Brand;
import model.Category;
import model.Product;
import repository.ProductRepository;
import repository.UserRepository;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class ProductService {

    private final ProductRepository productRepository;

    private final Scanner scanner = new Scanner(System.in);


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct() throws SQLException {
        System.out.println("Please enter product name :  ");
        String productName = scanner.next();

        System.out.println("Please enter product create date:  ");
        String inputDate = scanner.next();
        LocalDate createDate = null;
        try {
            createDate = LocalDate.parse(inputDate);
            System.out.println("Entered date: " + createDate);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }

        System.out.println("Please enter categoryId of the product :  ");
        int categoryId = scanner.nextInt();
        Category category = new Category();
        category.setCategoryId(categoryId);
        System.out.println("Please enter brandId of the product :  ");
        int brandId = scanner.nextInt();
        Brand brand = new Brand();
        brand.setBrandId(brandId);

        Product product = new Product(productName, createDate, category, brand);
        boolean insert = productRepository.saveProduct(product);
        System.out.println((insert == true) ? "Insert product successfully" : "Insert product unsuccessfully");
    }



    public void findَAllCategories() throws SQLException {
        System.out.println("Please show all product id and name :  ");
        Product[] products = productRepository.getAllProducts();
        if (products != null) {
            for (Product product : products) {
               // System.out.println("Product: " + product);
                 System.out.println("Product ID: " + product.getProductId() + ", Product Name: " + product.getProductName() + ", Product Create Date: " + product.getCreateDate()+ ", Product Category ID: " + product.getCategoryId()+ ", Product Brand ID: " + product.getBrandId());
            }
        } else {
            System.out.println("Failed to retrieve products.");
        }
    }

    public void findProduct() throws SQLException {
        System.out.println("Please enter product Id :  ");
        int productId = scanner.nextInt();

        Product existingProduct = productRepository.findByProductId(productId);
        if (existingProduct == null) {
            System.out.println("Product with ID " + productId + " not found.");
            return;
        }
        System.out.println("Current Product Information:");
        System.out.println(existingProduct);
    }

    public void updateProduct() throws SQLException {
        System.out.println("Please enter product id for update  :  ");
        int productId = scanner.nextInt();

        Product existingProduct = productRepository.findByProductId(productId);
        if (existingProduct == null) {
            System.out.println("Product with ID " + productId + " not found.");
            return;
        }

        System.out.println("Current Product Information:");
        System.out.println(existingProduct);

        System.out.println("Please update product name :  ");
        String newProductName = scanner.next();

        System.out.println("Please update product create date:  ");
        String newDate = scanner.next();
        LocalDate newCreateDate = null;
        try {
            newCreateDate = LocalDate.parse(newDate);
            System.out.println("Updated date: " + newCreateDate);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please update the date in yyyy-MM-dd format.");
        }

        System.out.println("Please update categoryId of the product:  ");
        int categoryId = scanner.nextInt();
        Category category = new Category();
        category.setCategoryId(categoryId);
        System.out.println("Please update brandId of the product :  ");
        int brandId = scanner.nextInt();
        Brand brand = new Brand();
        brand.setBrandId(brandId);

        Product product = new Product(productId, newProductName, newCreateDate, category, brand);
        boolean rowsUpdated = productRepository.update(product);

        if (rowsUpdated) {
            System.out.println("The category has been updated successfully.");
        } else {
            System.out.println("No changes were made, or an error occurred during the update.");
        }
    }

    public void deleteProduct() throws SQLException {
        System.out.println("Please enter product id for delete  :  ");
        int productId = scanner.nextInt();

        boolean rowsUpdated = productRepository.deleteProductById(productId);

        if (rowsUpdated) {
            System.out.println("The product has been deleted successfully.");
        } else {
            System.out.println("Product with ID " + productId + " not found for delete.");
        }
    }

}
