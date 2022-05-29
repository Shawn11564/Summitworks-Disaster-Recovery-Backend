//package com.summitworks.disasterrecovery.web.dto;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.management.relation.Role;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.validation.constraints.AssertTrue;
//
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
//
//import net.bst.springboot.springsecurity.constraint.FieldMatch;
//
//
//@FieldMatch.List({
//    @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
//    @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
//})
//public class UserRegistrationDto {
//	@NotBlank
//	private String username;
//
//	@NotBlank
//	@Email
//	private String email;
//
//	@NotBlank
//	private String password;
//
////	@ManyToMany(fetch = FetchType.LAZY)
////	@JoinTable(name = "user_roles",
////			joinColumns = @JoinColumn(name = "user_id"),
////			inverseJoinColumns = @JoinColumn(name = "role_id"))
////	private Set<Role> roles = new HashSet<>();
//	
//	
//	
//}
