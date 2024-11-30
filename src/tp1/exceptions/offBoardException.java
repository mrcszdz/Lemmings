package tp1.exceptions;

public class offBoardException extends GameModelException{
	public offBoardException () {
		super(); 
		}
	public offBoardException (String message){ 
		super(message);
	}
	public offBoardException (String message, Throwable cause){
	    super(message, cause);
	}
	public offBoardException (Throwable cause){ 
		super(cause); 
	}
}
