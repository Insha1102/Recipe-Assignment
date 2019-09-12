package com.example.Recipe;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.Recipe.controller.RecipeRestController;
import com.example.Recipe.entity.Recipe;
import com.example.Recipe.service.impl.RecipeServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RecipeApplication.class)
@SpringBootTest
public class RecipeApplicationTests {

	private MockMvc mockMvc;

	@InjectMocks
	RecipeRestController recipeController;


	@Mock
	private RecipeServiceImpl recipeService;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

	}

	@Test
	public void verifyToDoById() throws Exception {

		Recipe recipe = new Recipe(1L,"Dal Makhani","veg",2,"hruguerhg","sretrtetret","abcsdk");


		when(recipeService.getRecipe(1L)).thenReturn(recipe);


		mockMvc.perform(MockMvcRequestBuilders.get("/api/recipies/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.name").value("Dal Makhani"))
		.andExpect(jsonPath("$.indicator").value("veg"))
		.andExpect(jsonPath("$.servings").value(2))
		.andExpect(jsonPath("$.ingredients").value("hruguerhg"))
		.andExpect(jsonPath("$.instructions").value("sretrtetret"))
		.andExpect(jsonPath("$.image").value("abcsdk"))
		.andDo(print());
	}

}
