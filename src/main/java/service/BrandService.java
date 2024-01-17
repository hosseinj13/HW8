package service;

import repository.UserRepository;

public class BrandService {

    private final UserRepository userRepository;

    public BrandService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
