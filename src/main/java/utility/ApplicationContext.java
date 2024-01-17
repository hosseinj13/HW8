package utility;

import connection.JdbcConnection;
import repository.BrandRepository;
import repository.UserRepository;
import service.BrandService;
import service.UserService;
import java.sql.Connection;


public class ApplicationContext {

    private static final Connection CONNECTION;
    private static final UserRepository USER_REPOSITORY;
    private static final BrandRepository BRAND_REPOSITORY;


    private static final UserService USER_SERVICE;
    private static final BrandService BRAND_SERVICE;



    static{
        CONNECTION = JdbcConnection.getConnection();
        USER_REPOSITORY = new UserRepository(CONNECTION);
        USER_SERVICE = new UserService(USER_REPOSITORY);

        BRAND_REPOSITORY = new BrandRepository(CONNECTION);
        BRAND_SERVICE = new BrandService(BRAND_REPOSITORY);

    }

    public static UserService getUserService(){
        return USER_SERVICE;
    }

    public static UserService getBrandService(){
        return BRAND_SERVICE;
    }


}
