package com.example.Recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Recipe.entity.Recipe;
import com.example.Recipe.service.RecipeService;

@RestController
public class RecipeRestController {

	@Autowired
	private RecipeService recipeService;

	@GetMapping("/api/recipies")
	public List<Recipe> getRecipies() {
		List<Recipe> recipies = recipeService.retrieveRecipies();
		return recipies;
	}

	@GetMapping(value="/api/recipies/retrieveall", produces= MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recipe>> retrieveRecipies() {
		try {
			return new ResponseEntity<List<Recipe>>(recipeService.retrieveRecipies(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Recipe>>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/api/recipies/{recipeId}")
	public Recipe getRecipe(@PathVariable(name="recipeId")Long recipeId) {
		return recipeService.getRecipe(recipeId);
	}

	@PostMapping(value="/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveRecipe(@RequestBody Recipe recipe){
		System.out.println(recipe);
		recipeService.saveRecipe(recipe);

	}

	@DeleteMapping(path="/delete/{recipeId}")
	public String deleteRecipe(@PathVariable(name="recipeId")Long recipeId){
		recipeService.deleteRecipe(recipeId);
		return "redirect:recipelist.html";
	}

	@PutMapping("/api/recipies/{recipeId}")
	public void updateRecipe(@RequestBody Recipe recipe,
			@PathVariable(name="recipeId")Long recipeId){
		recipe.setId(recipeId);
		recipeService.updateRecipe(recipe);

	}

}
