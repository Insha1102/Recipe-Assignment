package com.example.Recipe.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RECIPE")
public class Recipe {
 
@Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 private Long id;
 
 @Column(name="RECIPE_NAME")
 private String name;
 
 @Column(name="INDICATOR")
 private String indicator;
 
 @Column(name="SERVINGS")
 private Integer servings;
 
 @Column(name="INGREDIENTS")
 private String ingredients;
 
 @Column(name="INSTRUCTIONS")
 private String instructions;

@Column(name="IMAGE")
 private String image;
 

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public Integer getServings() {
		return servings;
	}

	public void setServings(Integer servings) {
		this.servings = servings;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", indicator=" + indicator + ", servings=" + servings
				+ ", ingredients=" + ingredients + ", instructions=" + instructions + ", image=" + image + "]";
	}

	public Recipe() {
		super();
	}
	
	public Recipe(Long id, String name, String indicator, Integer servings, String ingredients, String instructions,
			String image) {
		super();
		this.id = id;
		this.name = name;
		this.indicator = indicator;
		this.servings = servings;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.image = image;
	}

	public Recipe(long l, String string, String string2, int i, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}


	
 
}
