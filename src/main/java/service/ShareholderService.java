package service;

import repository.ShareholderRepository;
import repository.UserRepository;

public class ShareholderService {

    private final ShareholderRepository shareholderRepository;

    public ShareholderService(ShareholderRepository shareholderRepository) {
        this.shareholderRepository = shareholderRepository;
    }
}
