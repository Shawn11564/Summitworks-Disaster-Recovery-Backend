package com.summitworks.disasterrecovery.models.users;

public enum UserRole {

	/*
	 *  Roles that a given user can have
	 *  check a user's role with {@link User#getUserRole() UserRole}
	 */
	ADMIN,
	CONTRACTOR;

	public static UserRole matchRole(String role) {
		return UserRole.valueOf(role.toUpperCase());
	}

}
