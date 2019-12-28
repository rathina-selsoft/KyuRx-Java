package com.selsoft.kyurx.constants;

public class UserConstant {
	
	public static enum USER_ROLE {

		Organization("Organization"), Doctor("Doctor"), User("User"), Patient("Patient"), Pharmacy("Pharmacy");

		private final String userRoleValue;

		private USER_ROLE(String value) {
			userRoleValue = value;
		}

		public String getUserRoleValue() {
			return this.userRoleValue;
		}

		public boolean equalsName(String value) {
			return userRoleValue.equals(value);
		}

		public String toString() {
			return this.userRoleValue;
		}
	}

	public static enum USER_STATUS {
		New("New"), Pending("Pending"), Active("Active"), InActive("InActive");

		private final String userStatusValue;

		private USER_STATUS(String value) {
			userStatusValue = value;
		}

		public String getUserStatusValue() {
			return this.userStatusValue;
		}

		public boolean equalsName(String value) {
			return userStatusValue.equals(value);
		}

		public String toString() {
			return this.userStatusValue;
		}
	}

}
