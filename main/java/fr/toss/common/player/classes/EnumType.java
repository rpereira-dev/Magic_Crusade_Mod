package fr.toss.common.player.classes;

public enum EnumType {
	
	DPS("Damage dealer", "He is specialized in attacking mobs."),
	HEALER("Healer", "He has to heal and buff other players."),
	TANK("Tank", "He should have more HP and Armor, and has to keep the mob focus to protect his mates.");
	
	String name;
	String description;

	EnumType(String p_name, String p_description)
	{
		this.name = p_name;
		this.description = p_description;
	}

}
