/**
 * 
 */
package com.example.Recipe.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Recipe.entity.Recipe;
import com.example.Recipe.repository.RecipeRepository;
import com.example.Recipe.service.RecipeService;

/**
 * @author C67592
 *
 */
public class RecipeServiceImplTest {
	
	@Mock
	private RecipeRepository recipeRepository;
	
	@InjectMocks
	private RecipeServiceImpl recipeService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	

	
	
	@Test
	public void testRetrieveRecipies(){
		List<Recipe> recipe = new ArrayList<Recipe>();
		recipe.add(new Recipe(1L,"Dal Makhani","veg",2,"hruguerhg","sretrtetret","abcsdk"));
		recipe.add(new Recipe(2L,"Butter Chicken","nonveg",4,"rgergergfr","sfsfsrfsr","abcvzvk"));
		recipe.add(new Recipe(3L,"Mix Veg","veg",1,"gsggvdfg","fzsdfuisdhfuidsh","arfrdk"));
		when(recipeRepository.findAll()).thenReturn(recipe);
		
		List<Recipe> result = recipeService.retrieveRecipies();
		assertEquals(3, result.size());
	}
	@Test
    public void getRecipeTest()
    {
		Recipe recipe = new Recipe(1L,"Dal Makhani","veg",2,"hruguerhg","sretrtetret","abcsdk");
		
		when(recipeRepository.findById(1L)).thenReturn(Optional.of(new Recipe(1L,"Dal Makhani","veg",2,"hruguerhg","sretrtetret","abcsdk")));
         
        Recipe rcp = recipeService.getRecipe(1L);
        assertEquals(1L, rcp.getId().longValue());
        assertEquals("Dal Makhani", rcp.getName());
        assertEquals("veg", rcp.getIndicator());
        assertEquals(2, rcp.getServings().intValue());
        assertEquals("hruguerhg",rcp.getIngredients());
        assertEquals("sretrtetret",rcp.getInstructions());
        assertEquals("abcsdk",rcp.getImage());
    }
	@Test
	public void saveRecipeTest(){
	    Recipe rcp = new Recipe(1L,"Dal Makhani","veg",2,"hruguerhg","sretrtetret","abcsdk");
		when(recipeRepository.save(rcp)).thenReturn(rcp);
		Recipe result = recipeService.saveRecipe(rcp);
		assertEquals(1L, result.getId().longValue());
		assertEquals("Dal Makhani", result.getName());
		assertEquals("veg", result.getIndicator());
	    assertEquals(2, rcp.getServings().intValue());
        assertEquals("hruguerhg",rcp.getIngredients());
        assertEquals("sretrtetret",rcp.getInstructions());
        assertEquals("abcsdk",rcp.getImage());
	}
	 
	 @Test
		public void deleteRecipeTest(){
			Recipe rcp = new Recipe(1L,"Dal Makhani","veg",2,"hruguerhg","sretrtetret","abcsdk");
			recipeService.deleteRecipe(rcp.getId());
	        verify(recipeRepository, times(1)).deleteById(rcp.getId());
		}
	 @Test
		public void updateRecipeTest()
		{
				Recipe newEntity = new Recipe(1L,"Dal Makhani","veg",2,"hruguerhg","sretrtetret","abcsdk");
				
				when(recipeRepository.saveAndFlush(newEntity)).thenReturn(newEntity);
							
				assertEquals("Success",recipeService.updateRecipe(newEntity));
		}
	 @Test
		public void updateRecipeTest1() 
		{
				when(recipeRepository.findById(1L)).thenReturn(Optional.empty());
				Recipe recSave = new Recipe(1L,"Dal Makhani updated","veg",2,"hruguerhg","sretrtetret","abcsdk");
				when(recipeRepository.saveAndFlush(recSave)).thenReturn(recSave);
				
				assertEquals("Success", recipeService.updateRecipe(recSave));
			}

}
