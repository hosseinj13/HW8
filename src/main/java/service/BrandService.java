package service;

import repository.BrandRepository;
import repository.UserRepository;

public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
}
