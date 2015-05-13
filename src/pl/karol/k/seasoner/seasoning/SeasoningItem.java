package pl.karol.k.seasoner.seasoning;

/**
 * A dummy item representing a piece of content.
 */
public final class SeasoningItem {
	
	public String id;
	public String nameEn;
	public String namePl;
	public String description;
	public String use;
	public String tip;

	public SeasoningItem(String id, String nameEn, String namePl, String desc, String use, String tip) {
		this.id = id;
		this.nameEn = nameEn;
		this.description = "[ " + id + " : " + nameEn + " ]";
	}

	@Override
	public String toString() {
		return nameEn;
	}
}
