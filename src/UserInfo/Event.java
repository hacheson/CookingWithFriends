/**
 * 
 */
package UserInfo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

/**
 * @author hacheson
 * This class represents an event: contains a date, name, and list of user.
 */
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date _date;
	private String _name;
	private HashSet<String> _users;
	
	public Event(String name, Date date, HashSet<String> u){
		_name = name;
		_date = date;
		_users = u;
	}
	
	/**
	 * Adds a user to the event.
	 * @param u
	 */
	public void addUser(String u){
		_users.add(u);
	}
	
	/**
	 * Removes a user from the event.
	 * @param u User The user to remove.
	 */
	public void removeUser(String u){
		_users.remove(u);
	}
	
	/**
	 * Sets the name of the event.
	 * @param name String name to set.
	 */
	public void setName(String name){
		_name = name;
	}
	
	/**
	 * Returns the event's name.
	 * @return String the name to return.
	 */
	public String getName(){
		return _name;
	}
	
	/**
	 * Sets this event's date.
	 * @param date String date to set.
	 */
	public void setDate(Date date){
		_date = date;
	}
	
	/**
	 * Returns this event's date.
	 * @return String date to return.
	 */
	public Date getDate(){
		return _date;
	}

	@Override
	public String toString() {
		return "Event [_date=" + _date + ", _name=" + _name + ", _users="
				+ _users + "]";
	}
	
}
