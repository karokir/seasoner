package pl.karol.k.seasoner.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.karol.k.seasoner.seasoning.SeasoningItem;

import android.app.Activity;
import android.content.res.Resources;

public final class ContentProvider {

	/**
	 * An array of sample seasonings.
	 */
	public static List<SeasoningItem> ITEMS = new ArrayList<SeasoningItem>();

	/**
	 * A map of sample seasonings, by ID.
	 */
	public static Map<String, SeasoningItem> ITEM_MAP = new HashMap<String, SeasoningItem>();

	private static final int minResourceId = 1;
	private static final int maxResourceIdPlus1 = 35;
	private static String resourceNamePrefix = "seasoning";
	private static final String resourceType = "array";

	public static void populateItemContainers(Activity activity) {
		String packageName = activity.getPackageName();
		Resources resources = activity.getResources();
		for (int i = minResourceId; i < maxResourceIdPlus1; i++) {
			int resourceId = resolveResourceId(resources, packageName, i);
			if (invalidResourceId(resourceId)) {
				continue;
			}
			String[] seasoningDetails = resources.getStringArray(resourceId);
			SeasoningItem seasoningItem = buildItem(Integer.toString(i), seasoningDetails);
			addItem(seasoningItem);
		}
		Collections.sort(ITEMS);
	}

	private static int resolveResourceId(Resources resources, String packageName, int i) {
		return resources.getIdentifier(resourceNamePrefix + i, resourceType, packageName);
	}

	private static boolean invalidResourceId(int resourceId) {
		return resourceId == 0;
	}

	private static SeasoningItem buildItem(String id, String[] seasoningDetails) {
		return new SeasoningItem(id, seasoningDetails[0], seasoningDetails[1], seasoningDetails[2], seasoningDetails[3], seasoningDetails[4]);
	}

	private static void addItem(SeasoningItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

}
