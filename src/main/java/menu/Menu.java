package menu;

import service.*;
import utility.ApplicationContext;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    private static final UserService userService = ApplicationContext.getUserService();
    private static final BrandService brandService = ApplicationContext.getBrandService();
    private static final CategoryService categoryService = ApplicationContext.getCategoryService();
    private static final ProductService productService = ApplicationContext.getProductService();
    private static final ShareholderService shareholderService = ApplicationContext.getShareholderService();
    private static final ShareholderBrandService shareholderBrandService = ApplicationContext.getShareholderBrandService();



    public Menu() throws SQLException {
    }

    public void publicMenu() throws SQLException {
        
        System.out.println("********** WELCOME **********");
        System.out.println("1-USER AUTHENTICATION");
        System.out.println("2-CATEGORY MENU");
        System.out.println("3-BRAND MENU");
        System.out.println("4-PRODUCT MENU");
        System.out.println("5-SHAREHOLDER MENU");
        System.out.println("6-SHAREHOLDER-BRAND MENU");
        System.out.println("Choose your number: ");

        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1 -> userMenu();
            case 2 -> categoryMenu();
            case 3 -> brandMenu();
            case 4 -> productMenu();
            case 5 -> shareholderMenu();
            case 6 -> shareholderBrandMenu();
        }
    }


    public void userMenu() throws SQLException {
        System.out.println("1-SIGN UP");
        System.out.println("2-SIGN IN");
        System.out.println("3-EXIT");
        System.out.println("Choose your number: ");

        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1 -> signup();
            case 2 -> signIn();
            case 3 -> System.out.println("exit");
        }
    }

    public void brandMenu() throws SQLException {
        System.out.println("1-ADD BRAND");
        System.out.println("2-FIND ALL BRAND");
        System.out.println("3-FIND BRAND");
        System.out.println("4-UPDATE BRAND");
        System.out.println("5-DELETE BRAND");
        System.out.println("Choose your number: ");

        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1 -> addBrand();
            case 2 -> findAllBrands();
            case 3 -> findBrand();
            case 4 -> updateBrand();
            case 5 -> deleteBrand();
        }
    }

    public void categoryMenu() throws SQLException {
        System.out.println("1-ADD CATEGORY");
        System.out.println("2-FIND ALL CATEGORY");
        System.out.println("3-FIND CATEGORY");
        System.out.println("4-UPDATE CATEGORY");
        System.out.println("5-DELETE CATEGORY");
        System.out.println("Choose your number: ");

        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1 -> addCategory();
            case 2 -> findAllCategories();
            case 3 -> findCategory();
            case 4 -> updateCategory();
            case 5 -> deleteCategory();
        }
    }

    public void productMenu() throws SQLException {
        System.out.println("1-ADD PRODUCT");
        System.out.println("2-FIND ALL PRODUCT");
        System.out.println("3-FIND PRODUCT");
        System.out.println("4-UPDATE PRODUCT");
        System.out.println("5-DELETE PRODUCT");
        System.out.println("Choose your number: ");

        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1 -> addProduct();
            case 2 -> findAllProducts();
            case 3 -> findProduct();
            case 4 -> updateProduct();
            case 5 -> deleteProduct();
        }
    }

    public void shareholderMenu() throws SQLException {
        System.out.println("1-ADD SHAREHOLDER");
        System.out.println("2-FIND ALL SHAREHOLDER");
        System.out.println("3-FIND SHAREHOLDER");
        System.out.println("4-UPDATE SHAREHOLDER");
        System.out.println("5-DELETE SHAREHOLDER");
        System.out.println("Choose your number: ");

        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1 -> saveShareholder();
            case 2 -> findَAllShareholders();
            case 3 -> findَShareholder();
            case 4 -> updateShareholder();
            case 5 -> deleteShareholder();
        }
    }

    public void shareholderBrandMenu() throws SQLException {
        System.out.println("1-ADD SHAREHOLDER_BRAND");
        System.out.println("2-FIND All SHAREHOLDER_BRAND");
        System.out.println("3-FIND SHAREHOLDER_BRAND");
        System.out.println("4-UPDATE SHAREHOLDER_BRAND");
        System.out.println("5-DELETE SHAREHOLDER_BRAND");
        System.out.println("Choose your number: ");

        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1 -> saveShareholderBrand();
            case 2 -> findAllShareholderBrand();
            case 3 -> findShareholderBrand();
            case 4 -> updateShareholderBrand();
            case 5 -> deleteShareholderBrand();
        }
    }

    public void signup() throws SQLException {
        userService.signup();
    }

    private void signIn() throws SQLException {
        userService.signIn();
    }

    public void addBrand() throws SQLException {
        brandService.addBrand();
    }

    public void findAllBrands() throws SQLException {
        brandService.findَAllBrands();
    }

    public void findBrand() throws SQLException {
        brandService.findBrand();
    }

    public void updateBrand() throws SQLException {
        brandService.updateBrand();
    }

    public void deleteBrand() throws SQLException {
        brandService.deleteBrand();
    }
    public void addCategory() throws SQLException {
        categoryService.addCategory();
    }

    public void findAllCategories() throws SQLException {
        categoryService.findَAllCategories();
    }

    public void findCategory() throws SQLException {
        categoryService.findCategory();
    }

    public void updateCategory() throws SQLException {
        categoryService.updateCategory();
    }

    public void deleteCategory() throws SQLException {
        categoryService.deleteCategory();
    }

    public void addProduct() throws SQLException {
        productService.addProduct();
    }

    public void findAllProducts() throws SQLException {
        productService.findَAllCategories();
    }

    public void findProduct() throws SQLException {
        productService.findProduct();
    }

    public void updateProduct() throws SQLException {
        productService.updateProduct();
    }

    public void deleteProduct() throws SQLException {
        productService.deleteProduct();
    }

    public void saveShareholder() throws SQLException {
        shareholderService.saveShareholder();
    }

    public void findَAllShareholders() throws SQLException {
        shareholderService.findَAllShareholders();
    }

    public void findَShareholder() throws SQLException {
        shareholderService.findShareholder();
    }

    public void updateShareholder() throws SQLException {
        shareholderService.updateShareholder();
    }

    public void deleteShareholder() throws SQLException {
        shareholderService.deleteShareholder();
    }
    public void saveShareholderBrand() throws SQLException {
        shareholderBrandService.saveShareholderBrand();
    }
    public void findAllShareholderBrand() throws SQLException {
        shareholderBrandService.findَAllShareholdersBrands();
    }

    public void findShareholderBrand() throws SQLException {
        shareholderBrandService.findShareholderBrand();
    }


    public void updateShareholderBrand() throws SQLException {
        shareholderBrandService.updateShareholderBrand();
    }
    public void deleteShareholderBrand() throws SQLException {
        shareholderBrandService.deleteShareholderBrand();
    }


}

