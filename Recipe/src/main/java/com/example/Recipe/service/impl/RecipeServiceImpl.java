package com.example.Recipe.service.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Recipe.repository.RecipeRepository;
import com.example.Recipe.entity.Recipe;
import com.example.Recipe.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeRepository recipeRepository;

	public void setRecipeRepository(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	public List<Recipe> retrieveRecipies() {
		List<Recipe> recipies = recipeRepository.findAll();
		return recipies;
	}

	public Recipe getRecipe(Long recipeId) {
		Optional<Recipe> optRcp = recipeRepository.findById(recipeId);
		return optRcp.get();
	}

	public Recipe saveRecipe(Recipe recipe){
		return  recipeRepository.save(recipe);
	}

	public void deleteRecipe(Long recipeId){
		recipeRepository.deleteById(recipeId);
	}

	public String updateRecipe(Recipe recipe) {
		recipeRepository.saveAndFlush(recipe);
		return "Success";
	}
}
