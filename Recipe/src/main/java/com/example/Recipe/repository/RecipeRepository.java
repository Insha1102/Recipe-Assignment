package com.example.Recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Recipe.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe,Long>{

}
