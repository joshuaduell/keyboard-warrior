package keyboard_warrior.world;

public class Location {

	private String name;
	private String description;

	public Location (String name, String description){
		this.name = name;
		this.description = description;
	}

	public void setDescription(String description){
		this.description = description;
	}
		
	public String getDescription(){
		return description;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public String toString(){
		return description;
	}
}

