package lab.aop;

public class AopLog {

	private static StringBuilder value = new StringBuilder();

	private AopLog() {
	}

	public static void append(String str) {
		value.append(str);
	}

	public static String getStringValue() {
		return value.toString();
	}

	public static void clear() {
		value = new StringBuilder();
	}

}