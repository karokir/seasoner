package pl.karol.k.seasoner.seasoning;

/**
 * A dummy item representing a piece of content.
 */
public final class SeasoningItem {
	
	public String id;
	public String name;
	public SeasoningType type;
	public String description;
	public String use;
	public String tip;

	public SeasoningItem(String id, String name, String type, String desc, String use, String tip) {
		this.id = id;
		this.name = name;
		this.type = SeasoningType.resolveType(type);
		this.description = desc;
		this.use = use;
		this.tip = tip;
	}

	@Override
	public String toString() {
		return name;
	}
}
