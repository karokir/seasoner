package pl.karol.k.seasoner.util;

import android.graphics.Color;
import pl.karol.k.seasoner.seasoning.SeasoningItem;
import pl.karol.k.seasoner.seasoning.SeasoningType;
import pl.karol.k.seasoner.util.HtmlFormattingHelper.HtmlTag;

public class SeasoningDecorator {

	private final SeasoningItem seasoningItem;
	private final String suggestedUse;
	private final String decorationSign = "~";

	public SeasoningDecorator(SeasoningItem seasoningItem, String suggestedUse) {
		this.seasoningItem = seasoningItem;
		this.suggestedUse = suggestedUse;
	}

	public String getFormattedString() {
		return getName() + HtmlTag.BREAK.openTag() + HtmlTag.BREAK.closeTag() + getDecorationBar(seasoningItem.name.length()) + HtmlTag.BREAK.openTag() + HtmlTag.BREAK.closeTag() + getDescription() + getUse() + getTip() + getDecorationBar(1);
	}

	private String getDecorationBar(int howLong) {
		String decorationBar = "";
		for (int i = 0; i < howLong; ++i) {
			decorationBar += decorationSign;
		}
		return HtmlFormattingHelper.format(HtmlFormattingHelper.format(decorationBar, HtmlTag.BOLD), HtmlTag.FONT.setColor(getColor()));
	}

	public String getName() {
		return HtmlFormattingHelper.format(seasoningItem.name, HtmlTag.BOLD);
	}

	public SeasoningType getType() {
		return seasoningItem.type;
	}

	public int getColor() {
		int color;
		switch (seasoningItem.type) {
			case HERB:
				color = Color.parseColor("#84c040");
				break;
			case SPICE:
				color = Color.parseColor("#f04400");
				break;
			case SAUCE:
				color = Color.parseColor("#f0c500");
				break;
			case MIX:
				color = Color.parseColor("#c04064");
				break;
			case GARNISH:
				color = Color.parseColor("#863670");
				break;
			default:
				color = Color.parseColor("#408bc0");
				break;
		}
		return color;
	}

	public String getDescription() {
		return HtmlFormattingHelper.format(seasoningItem.description, HtmlTag.PARAGRAPH, HtmlTag.SMALL);
	}

	public String getUse() {
		return HtmlFormattingHelper.format((HtmlFormattingHelper.format(suggestedUse, HtmlTag.BOLD) + " " + seasoningItem.use), HtmlTag.PARAGRAPH, HtmlTag.SMALL);
	}

	public String getTip() {
		return HtmlFormattingHelper.format(seasoningItem.tip, HtmlTag.PARAGRAPH, HtmlTag.SMALL);
	}
}
