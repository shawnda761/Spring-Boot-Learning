package com.adventureisland.demo.util;

public class ConstantUtil {
	
	public static final String SYS_DEFAULT_PASSWORD = "abcd!@#$1234";
	
	public static enum Result {
		RESULT_SUCCESS(true, "success"),
		RESULT_FAILURE(false, "failure");

		private final Boolean flag;
		private final String value;
		
		private Result(Boolean flag, String value) {
			this.flag = flag;
			this.value = value;
		}

		public Boolean getFlag() {
			return flag;
		}

		public String getValue() {
			return value;
		}
		
		public static Result getResult(Boolean flag) {
			for (Result result : Result.values()) {
				if (result.getFlag() == flag) {
					return result;
				}
			}
			return null;
		}
	}

	public static final String wrapperOfLike(String originalString) {
		return "%" + originalString + "%";
	}

}
