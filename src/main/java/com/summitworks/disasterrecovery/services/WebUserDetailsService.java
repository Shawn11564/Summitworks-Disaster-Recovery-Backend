//package com.summitworks.disasterrecovery.services;
//
//import java.util.Arrays;
//
//
//import com.summitworks.disasterrecovery.models.users.User;
//import com.summitworks.disasterrecovery.repositories.UserRepository;
//import com.summitworks.disasterrecovery.security.users.WebUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Service
//public class WebUserDetailsService implements UserDetailsService {
//	@Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
////    public User findByEmail(String email){
////        return userRepository.findByEmail(email);
////    }
//
////    public User save(UserRegistrationDto registration){
////        User user = new User();
////        user.setFirstName(registration.getFirstName());
////        user.setLastName(registration.getLastName());
////        user.setEmail(registration.getEmail());
////        user.setPassword(passwordEncoder.encode(registration.getPassword()));
////        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
////        return userRepository.save(user);
////    }
////
////    @Override
////    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////        User user = userRepository.findByEmail(email);
////        if (user == null){
////            throw new UsernameNotFoundException("Invalid username or password.");
////        }
////        return new org.springframework.security.core.userdetails.User(user.getEmail(),
////                user.getPassword(),
////                mapRolesToAuthorities(user.getRoles()));
////    }
////
////    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
////        return roles.stream()
////                .map(role -> new SimpleGrantedAuthority(role.getName()))
////                .collect(Collectors.toList());
////    }
//
//}