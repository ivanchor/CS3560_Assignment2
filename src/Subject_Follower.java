import java.util.ArrayList;
import java.util.List;

import Observer_Follower;

public class Subject_Follower {

	private List<Observer_Follower> observers = new ArrayList<Observer_Follower>();
	
	public void attach(Observer_Follower observer) {
		observers.add(observer);
	}
	
	public void detach(Observer_Follower observer) {
		observers.remove(observer);
	}
	
	public void notifyObserver_Followers() {
		for(Observer_Follower ob : observers) {
			ob.update(this);
		}
	}
}
