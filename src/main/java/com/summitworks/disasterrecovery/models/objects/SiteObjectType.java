package com.summitworks.disasterrecovery.models.objects;

public enum SiteObjectType {

	JOB_OBJECT(1),
	MACHINE_OBJECT(2);

	private final int databaseValue;

	private SiteObjectType(int databaseValue) {
		this.databaseValue = databaseValue;
	}

	public int getDatabaseValue() {
		return databaseValue;
	}

	public static SiteObjectType matchType(int databaseValue) {
		for (SiteObjectType type : values()) {
			if (type.getDatabaseValue() == databaseValue) {
				return type;
			}
		}

		return null;
	}

}
