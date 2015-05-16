package pl.karol.k.seasoner.seasoning;

public class HtmlFormattingHelper {

	public static String bold(String string) {
		return "<b>" + string + "</b>";
	}

	public static String italic(String string) {
		return "<i>" + string + "</i>";
	}

	public static String paragraph(String string) {
		return "<p>" + string + "</p>";
	}

	public static String small(String string) {
		return "<small>" + string + "</small>";
	}

	public static String color(String string, int color) {
		return "<font color=\"" + color + "\">" + string + "</font>";
	}
}
