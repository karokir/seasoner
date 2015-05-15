package pl.karol.k.seasoner.seasoning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.res.Resources;

import pl.karol.k.seasoner.SeasoningListActivity;

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
		String resourceType = "array";
		Resources resources = application.getResources();
		for (int i = 1; i < 35; i++) {
			int resId = resources.getIdentifier("seasoning" + i, resourceType, packageName);
			if (resId == 0) {
				continue;
			}
			String[] seasoningDetails = resources.getStringArray(resId);
			addItem(new SeasoningItem(Integer.toString(i), seasoningDetails[0], seasoningDetails[1], seasoningDetails[2], seasoningDetails[3], seasoningDetails[4]));
		}
	}

	private static void addItem(SeasoningItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

}
