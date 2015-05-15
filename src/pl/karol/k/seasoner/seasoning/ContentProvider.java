package pl.karol.k.seasoner.seasoning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.karol.k.seasoner.SeasoningListActivity;

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

	public static void populate(SeasoningListActivity application) {
		String packageName = application.getPackageName();
		String resourceType = "string";
		for (int i = 1; i < 33; i++) {
			int resId = application.getResources().getIdentifier("seasoning" + i, resourceType, packageName);
			if (resId == 0) {
				continue;
			}
			String seasoning = application.getString(resId);
			addItem(new SeasoningItem(Integer.toString(i), seasoning, "seasoning" + i, "seasoning" + i, "seasoning" + i, "seasoning" + i));
		}
	}

	private static void addItem(SeasoningItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

}
