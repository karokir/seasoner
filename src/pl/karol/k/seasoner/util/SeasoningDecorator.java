package pl.karol.k.seasoner.util;

import android.graphics.Color;
import pl.karol.k.seasoner.seasoning.SeasoningItem;
import pl.karol.k.seasoner.seasoning.SeasoningType;

public class SeasoningDecorator {

	private final SeasoningItem seasoningItem;
	private final String suggestedUse;
	private final String decorationSign = "~";

	public SeasoningDecorator(SeasoningItem seasoningItem, String suggestedUse) {
		this.seasoningItem = seasoningItem;
		this.suggestedUse = suggestedUse;
	}

	public String getFormattedString() {
		return getName() + HtmlFormattingHelper.breakAround(getDecorationBar(seasoningItem.name.length())) + getDescription() + getUse() + getTip() + getDecorationBar(1);
	}

	private String getDecorationBar(int howLong) {
		String decorationBar = "";
		for(int i = 0; i <  howLong; ++i) {
			decorationBar += decorationSign;
		}
		return HtmlFormattingHelper.color(HtmlFormattingHelper.bold(decorationBar), getColor());
	}

	public String getName() {
		return HtmlFormattingHelper.bold(seasoningItem.name);
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
		String small = HtmlFormattingHelper.small(seasoningItem.description);
		return HtmlFormattingHelper.paragraph(small);
	}

	public String getUse() {
		String small = HtmlFormattingHelper.small(HtmlFormattingHelper.bold(suggestedUse) + " " + seasoningItem.use);
		return HtmlFormattingHelper.paragraph(small);
	}

	public String getTip() {
		String small = HtmlFormattingHelper.small(seasoningItem.tip);
		return HtmlFormattingHelper.paragraph(small);
	}
}
