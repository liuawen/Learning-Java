package list.arraylist;

public class NonComparableElement extends RuntimeException {
	public NonComparableElement(String collection) {

		super("The " + collection + "is NonComparable.");
	}
}
