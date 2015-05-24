package pl.karol.k.seasoner.seasoning;

public enum SeasoningType {

	HERB, SPICE, MIX, SAUCE, GARNISH, OTHER;

	public static SeasoningType resolveSeasoningType(String typeName) {

		for (SeasoningType seasoningType : SeasoningType.values()) {
			if (seasoningType.name().equalsIgnoreCase(typeName)) {
				return seasoningType;
			}
		}
		return OTHER;
	}
}
