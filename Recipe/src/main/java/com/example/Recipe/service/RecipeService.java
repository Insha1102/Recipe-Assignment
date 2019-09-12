package com.example.Recipe.service;
import java.util.List;
import com.example.Recipe.entity.Recipe;

public interface RecipeService {
	 public List<Recipe> retrieveRecipies();
	 
	 public Recipe getRecipe(Long recipeId);
	 
	 public Recipe saveRecipe(Recipe recipe);
	 
	 public void deleteRecipe(Long recipeId);
	 
	 public String updateRecipe(Recipe recipe);
	 
	 
}
