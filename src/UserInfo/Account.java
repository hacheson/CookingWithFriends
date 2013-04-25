package UserInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;


/**
 * 
 * @author hacheson
 * This is the account class. It is what the home page will call to boot up. It has a user
 * but also has a list of recipes, ingredients, and shopping list.
 */
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User _user;
	private HashSet<Recipe> _recipes;
	private HashSet<String> _ingredients;
	private HashSet<String> _shoppingList;
	public Account(User user, HashSet<Recipe> recipes, HashSet<String> ingredients, HashSet<String> list){
		_user = user;
		_recipes = recipes;
		_ingredients = ingredients;
		//TODO: Will be generated by the api.
		_shoppingList = list;
	}
	
	public Account(User user){
		_user = user;
		_recipes = new HashSet<Recipe>();
		_ingredients = new HashSet<String>();
		_shoppingList = new HashSet<String>();
	}
	
	/**
	 * Returns the user of this account.
	 * @return User The user that this account returns.
	 */
	public User getUser(){
		return _user;
	}
	
	/**
	 * Sets the user of this account.
	 * @param u The user to set.
	 */
	public void setUser(User u){
		_user = u;
	}
	
	/**
	 * Sets the list of ingredients in the account.
	 * @param ing
	 */
	public void setIngredients(HashSet<String> ing){
		_ingredients = ing;
	}
	
	public void setShoppingList(HashSet<String> SL){
		_shoppingList = SL;
	}
	
	public Set<String> getShoppingList(){
		return _shoppingList;
	}
	
	/**
	 * Returns the list of ingredients in this account.
	 * @return HashSet<String> List of ingredients.
	 */
	public Set<String> getIngredients(){
		return _ingredients;
	}
	
	/**
	 * Sets the list of recipes in the account.
	 * @param r The list of recipes.
	 */
	public void setRecipes(HashSet<Recipe> r){
		_recipes = r;
	}
	
	/**
	 * Returns the list of recipes in this account.
	 * @return HashSet<String> List of recipes.
	 */
	public Set<Recipe> getRecipes(){
		return _recipes;
	}
	
}
