package stack.arrayStackImple;

public class EmptyCollectionException extends RuntimeException {

	private static final long serialVersionUID = 3560224030757364007L;

	public EmptyCollectionException(String collection) {
		super("The " + collection + "is Empty.");
	}

}
