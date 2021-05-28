//package com.example.shop.config;
//
//import com.example.shop.repository.CustomerRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AppUserService implements UserDetailsService {
//
//    private final CustomerRepository customerRepository;
//    private final AppUserRepository appUserRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        return appUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user with email %s not found"));
//    }
//
//    public String signUpUser(AppUser appUser) {
//        boolean present = appUserRepository.findByEmail(appUser.getEmail())
//                .isPresent();
//
//        if(present) {
//            throw new IllegalStateException("email already taken");
//        }
//
//        String encode = bCryptPasswordEncoder.encode(appUser.getPassword());
//
//        appUser.setPassword(encode);
//
//        appUserRepository.save(appUser);
//
//        //confirmation token
//
//        return "";
//    }
//}
