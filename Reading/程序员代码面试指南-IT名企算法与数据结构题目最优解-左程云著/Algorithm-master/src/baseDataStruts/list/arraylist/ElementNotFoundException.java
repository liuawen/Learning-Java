package list.arraylist;

public class ElementNotFoundException extends RuntimeException {
	public ElementNotFoundException(String collection) {
		super("The " + collection + "is Not Have This Element.");
	}
}
