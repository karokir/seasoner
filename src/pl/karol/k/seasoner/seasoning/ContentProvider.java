package pl.karol.k.seasoner.seasoning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 */
public class ContentProvider {

	/**
	 * An array of sample seasonings.
	 */
	public static List<SeasoningItem> ITEMS = new ArrayList<SeasoningItem>();

	/**
	 * A map of sample seasonings, by ID.
	 */
	public static Map<String, SeasoningItem> ITEM_MAP = new HashMap<String, SeasoningItem>();

	static {
		addItem(new SeasoningItem("1", "seasoning 1", "seasoning 1", "seasoning 1", "seasoning 1", "seasoning 1"));
		addItem(new SeasoningItem("2", "seasoning 2", "seasoning 2", "seasoning 2", "seasoning 2", "seasoning 2"));
		addItem(new SeasoningItem("3", "seasoning 3", "seasoning 3", "seasoning 3", "seasoning 3", "seasoning 3"));
		for (int i = 4; i < 8; ++i) {
			addItem(new SeasoningItem(Integer.toString(i), "seasoning" + i, "seasoning" + i, "seasoning" + i, "seasoning" + i, "seasoning" + i));
		}
	}

	private static void addItem(SeasoningItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

}
