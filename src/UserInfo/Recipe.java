package UserInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for Recipes stored by the user.
 * @author hacheson & jschear
 *
 */
public interface Recipe extends Serializable {
	
	public String getName();
	
	public List<String> getIngredients();
	
	public String getYield();
	
	public String getInstructions();
	
	public String getNumberOfServings();
	
	public String getID();
	
	public String getTime();
	
	public String getImageUrl();
}
