public class Mini_Twitter_Service
{
	
	protected static Mini_Twitter_Service instance;
	
	protected Mini_Twitter_Service() { }
	
	public static Mini_Twitter_Service getInstance() {
		if (instance == null) {
			instance = new Mini_Twitter_Service();
		}
		return instance;
	}
	
	

	private String courseName;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}