
public class Driver 
{
	public static void main(String[] args)
	{
		Mini_Twitter miniTwitter = new Mini_Twitter();
		miniTwitter.setVisible(true);
		System.out.println("Driver running");
		
		Mini_Twitter_Service Twitter_Instance = new Mini_Twitter_Service();
		Twitter_Instance.getInstance();
	}
}