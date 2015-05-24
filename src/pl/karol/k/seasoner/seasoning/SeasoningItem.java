package pl.karol.k.seasoner.seasoning;

/**
 * An item representing a piece of content.
 */
public final class SeasoningItem implements Comparable<SeasoningItem> {

	public String id;
	public String name;
	public SeasoningType type;
	public String description;
	public String use;
	public String tip;

	public SeasoningItem(String id, String name, String type, String desc, String use, String tip) {
		this.id = id;
		this.name = name;
		this.type = SeasoningType.resolveSeasoningType(type);
		this.description = desc;
		this.use = use;
		this.tip = tip;
	}

	@Override
	public String toString() {
		return name;
	}

	/**
	 * lexicographical comparison by name
	 */
	@Override
	public int compareTo(SeasoningItem another) {
		return this.name.compareTo(another.name);
	}
}
