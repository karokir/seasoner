package pl.karol.k.seasoner.util;

public class HtmlFormattingHelper {

	public enum HtmlTag {
		BOLD("b"), ITALIC("i"), PARAGRAPH("p"), SMALL("small"), BREAK("br");
		
		private String tag;
		
		HtmlTag(String tag) {
			this.tag = tag;
		}
		
		String openTag() {
			return "<" + tag + ">";
		}

		String closeTag() {
			return "</" + tag + ">";
		}
		
		String getOpenCloseTag() {
			return "<" + tag + "/>";
		}
	}

	public static String formatt(String string, HtmlTag...tags) {
		for (HtmlTag tag : tags) {
			string = applyFormatting(string, tag);
		}
		return string;
	}

	private static String applyFormatting(String string, HtmlTag tag) {
		return tag.openTag() + string + tag.closeTag();
	}
	
	public static String color(String string, int color) {
		return "<font color=\"" + color + "\">" + string + "</font>";
	}
}
