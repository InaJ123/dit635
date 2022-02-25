package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;

public class CoffeMakerTest {
    private CoffeeMaker cm;
    private Recipe r1;
    private RecipeBook rb;
    private Recipe r2;
    private Recipe r3;

    @Before
    public void setUp() throws Exception {
        cm = new CoffeeMaker();
        rb = new RecipeBook();

        /*****    Recipe 1      *****/
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("40");

        r2 = new Recipe();
        r2.setName("Chocolate");
        r2.setAmtChocolate("0");
        r2.setAmtCoffee("3");
        r2.setAmtMilk("1");
        r2.setAmtSugar("1");
        r2.setPrice("50");

        r3 = new Recipe();
        r3.setName("Chocolate");
        r3.setAmtChocolate("20");
        r3.setAmtCoffee("30");
        r3.setAmtMilk("17");
        r3.setAmtSugar("30");
        r3.setPrice("50");
    }

    @Test
    public void TestAddRecipe() {
        Boolean addRecipe = rb.addRecipe(r1);
        assertEquals(true, addRecipe);
    }

    @Test
    public void TestAddRecipeTwice() {
        Recipe[] recipes = cm.getRecipes();
        cm.addRecipe(r1);
        assertFalse(cm.addRecipe(r1));
    }

    @Test
    public void TestDeleteRecipe() {
        cm.addRecipe(r1);
        String expected = r1.getName();
        assertEquals(expected, cm.deleteRecipe(0));

    }

    @Test
    public void TestDeleteRecipeNull() {
        assertEquals(null, cm.deleteRecipe(0));

    }

    @Test
    public void TestEditRecipe() {
        cm.addRecipe(r1);
        Recipe recipe = new Recipe();
        recipe.setName("hi");
        Recipe[] recipes = new Recipe[4];
        cm.editRecipe(0, r2);
        recipes[0] = recipe;
        assertEquals(r1, cm.getRecipes()[0]);

    }
    @Test
    public void TestEditRecipeNotExisting() {
        assertEquals(null, cm.editRecipe(0, r1));

    }

    @Test
    public void TestAddInventory() {
        try {
            cm.addInventory("3", "6", "0", "10");
        } catch (InventoryException e) {
            fail("InventoryException should not be thrown");
        }
        String expected = "Coffee: 18\nMilk: 21\nSugar: 15\nChocolate: 25\n"; // Everything in the inventory starts at 15
        assertEquals(expected, cm.checkInventory());

    }
    @Test
    public void testAddNegativeNumbersInventory() {
        assertThrows(InventoryException.class, () ->
        {
            cm.addInventory("-1", "-3", "0", "-8");
        });
    }

    @Test
    public void TestCheckInventory() {
        String expected = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        assertEquals(expected, cm.checkInventory());
    }

    @Test
    public void TestMakeCoffee() {
        cm.addRecipe(r1);
        cm.makeCoffee(0,50);
        assertEquals(10, cm.makeCoffee(0, 50));

    }

    @Test
    public void TestMakeCoffeeBranchCoverage() {
        cm.addRecipe(r1);
        cm.makeCoffee(0,30);
        assertEquals(30, cm.makeCoffee(0, 30));

    }

    @Test
    public void TestMakeCoffeeBranchCoverage2() {
        cm.addRecipe(r3);
        cm.makeCoffee(0,50);
        assertEquals(50, cm.makeCoffee(0, 50));

    }

    @Test
    public void TestMakeCoffeeNegativeAmountPaid() {
        cm.addRecipe(r1);
        cm.makeCoffee(0,-10);
        assertEquals(0, cm.makeCoffee(0, -10));

    }
    @Test
    public void TestMakeCoffeeNotExisting() {
        cm.makeCoffee(0,50);
        assertEquals(50, cm.makeCoffee(0, 50));

    }

    @Test
    public void getRecipes() {
        cm.addRecipe(r1);
        Recipe[] recipes = new Recipe[4];
        recipes[0] = r1;
        assertArrayEquals(recipes, cm.getRecipes());

    }

}
