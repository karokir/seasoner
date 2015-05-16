package pl.karol.k.seasoner.util;

import android.graphics.Color;
import pl.karol.k.seasoner.seasoning.HtmlFormattingHelper;
import pl.karol.k.seasoner.seasoning.SeasoningItem;
import pl.karol.k.seasoner.seasoning.SeasoningType;

public class SeasoningDecorator {

	private final SeasoningItem seasoningItem;
	private final String suggestedUse = "Suggested use:";

	public SeasoningDecorator(SeasoningItem seasoningItem) {
		this.seasoningItem = seasoningItem;
	}

	public String getFormattedString() {
		return getName() + getDescription() + getUse() + getTip();
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
			color = Color.rgb(0, 196, 32);
			break;
		case SPICE:
			color = Color.rgb(196, 0, 32);
			break;
		case SAUCE:
			color = Color.rgb(196, 128, 0);
			break;
		case MIX:
			color = Color.rgb(196, 0, 128);
			break;
		case GARNISH:
			color = Color.rgb(0, 32, 196);
			break;
		default:
			color = Color.rgb(0, 0, 0);
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
