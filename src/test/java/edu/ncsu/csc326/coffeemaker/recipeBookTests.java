package edu.ncsu.csc326.coffeemaker;


import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Example Unit tests for CoffeeMaker class.
 * Do not submit as your own!
 */
public class recipeBookTests {

    private Recipe r1;
    private Recipe r2;

    @BeforeEach
    public void setUp() throws Exception {

        //Set up for r1
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");

        //Set up for r2
        r2 = new Recipe();
        r2.setName("Mocha");
        r2.setAmtChocolate("20");
        r2.setAmtCoffee("3");
        r2.setAmtMilk("1");
        r2.setAmtSugar("1");
        r2.setPrice("75");
    }


    @Test
    public void addRecipe() {
        RecipeBook rb = new RecipeBook();
        assertTrue(rb.addRecipe(r1));
        assertFalse(rb.addRecipe(r1));

    }
    @Test
    public void getRecipes() {
        RecipeBook rb = new RecipeBook();
        assertTrue(rb.addRecipe(r1));
        assertEquals(1, rb.getRecipes().length);
    }

    @Test
    public void deleteRecipe() {
        RecipeBook rb = new RecipeBook();
        rb.addRecipe(r1);
        assertEquals(r1.getName(), rb.deleteRecipe(0));
        assertNull(rb.deleteRecipe(0));
    }

    @Test
    public void editRecipe() {
        RecipeBook rb = new RecipeBook();
        rb.addRecipe(r1);
        assertEquals(r1.getName(), rb.editRecipe(0, r2));
        assertEquals(r2.getName(), rb.getRecipes()[0].getName());
    }



}
