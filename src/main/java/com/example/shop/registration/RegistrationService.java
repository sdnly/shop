//package com.example.shop.registration;
//
//import com.example.shop.config.AppUser;
//import com.example.shop.config.AppUserRole;
//import com.example.shop.config.AppUserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class RegistrationService {
//
//    private final EmailValidator emailValidator;
//    private final AppUserService appUserService;
//
//    public String register(RegistrationRequest request) {
//        boolean isValidEmail = emailValidator.test(request.getEmail());
//        if(!isValidEmail) {
//            throw new IllegalStateException("email not valid");
//        }
//        return appUserService.signUpUser(
//                new AppUser(
//                        request.getFirstName(),
//                        request.getLastName(),
//                        request.getEmail(),
//                        request.getPassword(),
//                        AppUserRole.USER
//                )
//        );
//    }
//}
