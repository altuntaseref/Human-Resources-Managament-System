package kodlamaio.hrms.core.utilities.results;

public class SuccsessResult extends Result {
	
	public SuccsessResult(boolean success) {
		super(true);
	}
	
	public SuccsessResult(String message) {
		super(true, message);
	}

}
