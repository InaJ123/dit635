// Assignment 2
// Group 22
// Ina, Ann-Sofie, Mario, Sofia

package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class RecipeTest {
    private Recipe r1;
    private Recipe r2;
    private Assertions check;

    @Before
    public void setUp() throws RecipeException {
        r1 = new Recipe();
        //Set up for r1
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");

        r2 = new Recipe();
        r1.setName("Chocolate");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");

    }

    @Test // Test nr 1 --> test for retrieving recipe
    public void testGetRecipe() {
        String recipe1 = r1.getName();
        assertEquals("Coffee", recipe1);
        System.out.println(recipe1);

    }


    @Test // Test nr 3 - Test if price of recipe can be edited
    public void testSetRecipe() {
        r1.setName("Caramel macchiato");
        check.assertEquals("Caramel macchiato", r1.getName());
        System.out.println(r1.getName());
    }

    @Test // Test nr 2.5 - Recipe no input
    public void testRecipeNoInput(){
        check.assertThrows(RecipeException.class, () -> r1.setPrice(""));
    }

    @Test // Test nr 2 -->  Test if the correct price was provided
    public void testGetPrice() {
        int price1 = r1.getPrice();
        assertEquals(50, price1);
        System.out.println("Price is 50");

    }

    @Test // Test nr 3 - Test if price of recipe can be edited
    public void testSetPrice() {
        try {
            r1.setPrice("66");
            check.assertEquals(66, r1.getPrice());
            System.out.println(r1.getPrice());
        } catch (RecipeException e) {
            check.fail("A recipe exception occurred");

        }
    }

    @Test // Test nr 3.5 - test price no input
    public void testPriceNoInput(){
        check.assertThrows(RecipeException.class, () -> r1.setPrice(""));
    }

    @Test // Test nr 4 - Test if sugar can be retrieved
    public void testGetAmtSugar() {
        check.assertEquals(1, r1.getAmtSugar());

    }

    @Test // Test nr 5 - Test if sugar amount can be edited
    public void testSetAmtSugar() {
        try {
            r1.setAmtSugar("10");
            check.assertEquals(10, r1.getAmtSugar());
            System.out.println(r1.getAmtSugar());
        } catch (RecipeException e) {
            check.fail("You have received a recipe exception");
        }

    }

    @Test
    public void testSetAmtSugarInvalid(){
        check.assertThrows(RecipeException.class, () -> r1.setAmtSugar("Hehe"));
    }

    @Test  // Test nr 6 - Test if coffee can be retrieved
    public void testGetAmtCoffee() {
        check.assertEquals(3, r1.getAmtCoffee());
    }

    @Test // Test nr 7.5 - Check if coffee has negative value
    public void testCoffeeIsNegative() {
        check.assertThrows(RecipeException.class, () -> r1.setAmtCoffee(-1+""));
    }


    @Test // Test nr 7 - Test if coffee can be edited
    public void testSetAmtCoffee() {
        try {
            r1.setAmtCoffee("2");
            check.assertEquals(2, r1.getAmtCoffee());
            System.out.println(r1.getAmtCoffee());
        } catch (RecipeException e) {
            check.fail("You have received a recipe exception");
        }
    }


    @Test // Test nr 8 - test if amount chocolate can be retrieved
    public void testGetAmtChocolate() {
        check.assertEquals(3, r1.getAmtCoffee());
    }


    @Test // Test nr 9 - test if amount of chocolate can be edited
    public void testSetAmtChocolate() {
        try {
            r1.setAmtChocolate("10");
            check.assertEquals(10, r1.getAmtChocolate());
            System.out.println(r1.getAmtChocolate());
        } catch (RecipeException e) {
            check.fail("You have received a recipe exception");
        }
    }

    @Test
    public void testSetAmtChocolateInvalid(){
        check.assertThrows(RecipeException.class, () -> r1.setAmtChocolate("Oops"));
    }

    @Test // Test nr 10 - try retrieve amount of milk
    public void testGetAmtMilk() {
        check.assertEquals(1, r1.getAmtMilk());
    }

    @Test // Test nr 11 - try to edit amount of milk
    public void testSetAmtMilk() {
        try {
            r1.setAmtMilk("1");
            check.assertEquals(1, r1.getAmtMilk());
            System.out.println(r1.getAmtMilk());
        } catch (RecipeException e) {
            check.fail("You have received a recipe exception");
        }
    }

    @Test // Test nr 12 - Check if value is null
    public void testMilkIsNegative() {
        check.assertThrows(RecipeException.class, () -> r1.setAmtMilk(-1+""));
    }
}
