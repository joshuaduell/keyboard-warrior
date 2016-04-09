package keyboard_warrior.inventory;

public class Item {
	
	private String name;
	private String description;

	public Item (String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setItemName(String name){
		this.name = name;
	}

	public String getDescription(){
		return description;
	}

	public void setItemDescription(String name)
	{
		this.description = description;
	}

	public String toString()
	{
		return name + ": " + description;
	}
}

