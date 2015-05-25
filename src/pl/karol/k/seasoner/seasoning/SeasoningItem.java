package pl.karol.k.seasoner.seasoning;

/**
 * An item representing a piece of content.
 */
public final class SeasoningItem implements Comparable<SeasoningItem> {

	private String id;
	private String name;
	private SeasoningType type;
	private String description;
	private String use;
	private String tip;

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

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public SeasoningType getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public String getUse() {
		return use;
	}

	public String getTip() {
		return tip;
	}

}
