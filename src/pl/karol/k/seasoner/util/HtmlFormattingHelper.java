package pl.karol.k.seasoner.util;

public class HtmlFormattingHelper {

	public enum HtmlTag {
		BOLD("b"), ITALIC("i"), PARAGRAPH("p"), SMALL("small"), BREAK("br"), FONT("font");

		private String tag;
		private int color;

		HtmlTag(String tag) {
			this.tag = tag;
		}
		
		HtmlTag setColor(int color) {
			this.color = color;
			return this;
		}

		String openTag() {
			String openTag = "<" + tag;
			if(color != 0) {
				openTag += " color=\"" + color + "\"";
			}
			openTag += ">";
			return openTag;
		}

		String closeTag() {
			return "</" + tag + ">";
		}

	}

	public static String format(String string, HtmlTag... tags) {
		for (HtmlTag tag : tags) {
			string = applyFormatting(string, tag);
		}
		return string;
	}

	private static String applyFormatting(String string, HtmlTag tag) {
		return tag.openTag() + string + tag.closeTag();
	}
}
