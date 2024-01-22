package service;

import model.Brand;
import model.Category;
import model.Product;
import model.Shareholder;
import repository.ShareholderRepository;
import repository.UserRepository;
import utility.NationalCodeValidator;
import utility.PhoneNumberValidator;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderService {

    private final ShareholderRepository shareholderRepository;

    private final Scanner scanner = new Scanner(System.in);


    public ShareholderService(ShareholderRepository shareholderRepository) {
        this.shareholderRepository = shareholderRepository;
    }

    public void saveShareholder() throws SQLException {
        System.out.println("Please enter shareholder name :  ");
        String name = scanner.nextLine();
        System.out.println("Please enter shareholder phoneNumber:  ");
        String phoneNumber = scanner.nextLine();
        if (PhoneNumberValidator.isIranianPhoneNumberValid(phoneNumber)) {
            System.out.println("Iranian phone number is valid!");
        } else {
            System.out.println("Invalid Iranian phone number. Please enter a valid phone number.");
            return;
        }
        System.out.println("Please enter shareholder nationalCode:  ");
        String nationalCode = scanner.nextLine();
        if (NationalCodeValidator.isNationalCodeValid(nationalCode)) {
            System.out.println("National code is valid!");
        } else {
            System.out.println("Invalid national code. Please enter a valid national code.");
            return;
        }
        Shareholder shareholder = new Shareholder(name, phoneNumber, nationalCode);

        boolean insert = shareholderRepository.addShareholder(shareholder);
        System.out.println((insert == true) ? "Insert shareholder successfully" : "Insert shareholder unsuccessfully");
    }


    public void findَAllShareholders() throws SQLException {
        System.out.println("Please show all shareholder id and name :  ");
        Shareholder[] shareholders = shareholderRepository.getAllShareholder();
        if (shareholders != null) {

            for (Shareholder shareholder : shareholders) {
                System.out.println("Shareholder ID: " + shareholder.getShareholderId() + ", Shareholder Name: " + shareholder.getShareholderName()+ ", Shareholder PhoneNumber: " + shareholder.getPhoneNumber() + ", Shareholder NationalCode: " + shareholder.getNationalCode());
                //System.out.println(shareholder);
            }
        } else {
            System.out.println("Failed to retrieve shareholders.");
        }
    }


    public void findShareholder() throws SQLException {
        System.out.println("Please enter shareholder Id :  ");
        int shareholderId = scanner.nextInt();

        Shareholder existingShareholder = shareholderRepository.findByShareholderId(shareholderId);
        if (existingShareholder == null) {
            System.out.println("Brand with ID " + shareholderId + " not found.");
            return;
        }
        System.out.println("Current Shareholder Information:");
        System.out.println(existingShareholder);
    }

    public void updateShareholder() throws SQLException {
        System.out.println("Please enter shareholder id for update  :  ");
        int shareholderId = scanner.nextInt();

        Shareholder existingShareholder = shareholderRepository.findByShareholderId(shareholderId);
        if (existingShareholder == null) {
            System.out.println("Shareholder with ID " + shareholderId + " not found.");
            return;
        }

        System.out.println("Current Shareholder Information:");
        System.out.println(existingShareholder);

        System.out.println("Please update shareholder name :  ");
        String newShareholderName= scanner.next();
        System.out.println("Please update shareholder phoneNumber:  ");
        String newShareholderPhoneNumber = scanner.next();
        if (PhoneNumberValidator.isIranianPhoneNumberValid(newShareholderPhoneNumber)) {
            System.out.println("Iranian phone number is valid!");
        } else {
            System.out.println("Invalid Iranian phone number. Please enter a valid phone number.");
            return;
        }
        System.out.println("Please update shareholder nationalCode:  ");
        String newShareholderNationalCode = scanner.next();
        if (NationalCodeValidator.isNationalCodeValid(newShareholderNationalCode)) {
            System.out.println("National code is valid!");
        } else {
            System.out.println("Invalid national code. Please enter a valid national code.");
            return;
        }

        Shareholder shareholder = new Shareholder(shareholderId, newShareholderName, newShareholderPhoneNumber, newShareholderNationalCode);
        boolean rowsUpdated = shareholderRepository.update(shareholder);

        if (rowsUpdated) {
            System.out.println("The shareholder has been updated successfully.");
        } else {
            System.out.println("No changes were made, or an error occurred during the update.");
        }
    }

    public void deleteShareholder() throws SQLException {
        System.out.println("Please enter shareholder id for delete  :  ");
        int shareholderId = scanner.nextInt();

        boolean rowsUpdated = shareholderRepository.deleteShareholderById(shareholderId);

        if (rowsUpdated) {
            System.out.println("The shareholder has been deleted successfully.");
        } else {
            System.out.println("Shareholder with ID " + shareholderId + " not found for delete.");
        }
    }

}
