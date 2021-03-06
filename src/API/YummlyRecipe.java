package API;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import UserInfo.Recipe;
/**
 * Recipe stored by the user.
 * @author jschear
 *
 */
public class YummlyRecipe implements Recipe {

	private static final long serialVersionUID = 1L;
	
	//Indicated whether the recipe info has been read in completely from the API.
	public boolean isFullRecipe;
	
	//Fields from Yummly search query
	private String id;
	private String recipeName;
	private double rating;
	private String[] smallImageUrls;
	private String sourceDisplayName;
	private int totalTimeInSeconds;
	private String[] ingredients;
	private Map<String, String[]> attributes;
	private Map<String, Double> flavors;
	
	//Additional fields from Yummly recipe query
	private Map<String, String> attribution;
	private String[] ingredientLines;
	//images??
	private String yield;
	private String totalTime;
	private String numberOfServings;
	private Map<String, String> source;
	
	
	public YummlyRecipe() {
		
	}


	@Override
	public String toString() {
		return "Recipe [id=" + id + ", recipeName=" + recipeName
				+ ", ingredients=" + Arrays.toString(ingredients) + "]";
	}


	@Override
	public String getName() {
		return recipeName;
	}


	@Override
	public List<String> getIngredients() {
		return Arrays.asList(ingredients);
	}


	@Override
	public String getYield() {
		return yield;
	}


	@Override
	public String getInstructions() {
		StringBuilder instructions = new StringBuilder();
		for (String line : ingredientLines) {
			instructions.append(line);
		}
		return instructions.toString();
	}


	@Override
	public String getNumberOfServings() {
		return numberOfServings;
	}


	@Override
	public String getID() {
		return id;
	}


	@Override
	public String getTime() {
		return (totalTime == null ? Integer.toString(totalTimeInSeconds) : totalTime);
	}


	@Override
	public String getImageUrl() {
		// TODO IMPLEMENT THIS
		return null;
	}
}
