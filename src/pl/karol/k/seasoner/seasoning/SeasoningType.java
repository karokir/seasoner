package pl.karol.k.seasoner.seasoning;

public enum SeasoningType {

	HERB, SPICE, MIX, SAUCE, GARNISH, OTHER;

	public static SeasoningType resolveType(String type) {
		SeasoningType seasoningType;
		switch (type) {
		case "herb":
			seasoningType = HERB;
			break;
		case "spice":
			seasoningType = SPICE;
			break;
		case "mix":
			seasoningType = MIX;
			break;
		case "sauce":
			seasoningType = SAUCE;
			break;
		case "garnish":
			seasoningType = GARNISH;
			break;
		default:
			seasoningType = OTHER;
			break;
		}
		return seasoningType;
	}
}
