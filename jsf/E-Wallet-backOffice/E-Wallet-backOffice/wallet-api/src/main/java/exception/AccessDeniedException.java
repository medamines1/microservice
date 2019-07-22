package exception;

public class AccessDeniedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Parameterless Constructor
    public AccessDeniedException() {}

    // Constructor that accepts a message
    public AccessDeniedException(String message)
    {
       super(message);
    }
}
