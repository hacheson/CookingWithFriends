package ClientServerRequests;

import java.io.Serializable;
import java.util.HashMap;

import UserInfo.Account;
import UserInfo.Invitation;
import UserInfo.Kitchen;

public class RequestReturn implements Serializable {
	
	private static final long serialVersionUID = 1L;

	int _type;
	Account _account;
	Kitchen _kitchen;
	boolean _checkPass;
	HashMap<String, Kitchen> _kitchenMap;
	Invitation _invite;
	
	/*
	 * Types:
	 *   1 -- Password Check (extract getCorrect())
	 *   2 -- Singular Kitchen (extract getKitchen)
	 *   3 -- Invitation
	 */
	
	public RequestReturn(int type){
		_type = type;
	}
	
	public int getType(){
		return _type;
	}
	
	public void setCorrect(boolean correct){
		_checkPass = correct;
	}
	
	public boolean getCorrect(){
		return _checkPass;
	}
	
	public void setAccount(Account acc){
		_account = acc;
	}
	
	public Account getAccount(){
		return _account;
	}
	
	public void setKitchen(Kitchen kit){
		_kitchen = kit;
	}
	
	public Kitchen getKitchen(){
		return _kitchen;
	}
	
	public void setKitchenMap(HashMap<String, Kitchen> kits){
		_kitchenMap = kits;
	}
	
	public HashMap<String, Kitchen> getKitchenMap(){
		return _kitchenMap;
	}
	
	public void setInvitation(Invitation invite){
		_invite = invite;
	}
	
	public Invitation getInvitation(){
		return _invite;
	}
}
