package repository;

import java.sql.Connection;

public class ShareholderRepository {

    private final Connection connection;
    public ShareholderRepository(Connection connection){
        this.connection = connection;
    }
}
