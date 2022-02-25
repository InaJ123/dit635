// Assignment 2
// Group 22
// Ina, Ann-Sofie, Mario, Sofia

package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class RecipeTest {
    private Recipe r1;
    private Recipe r2;

    @Before
    public void setUp() throws RecipeException {
        r1 = new Recipe();
        //Set up for r1
        r1.setName("name");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("66");

        r2 = new Recipe();
        r2.setName("name");
        r2.setAmtChocolate("0");
        r2.setAmtCoffee("3");
        r2.setAmtMilk("1");
        r2.setAmtSugar("1");
        r2.setPrice("66");

    }

    @Test
    public void checkChocolateIsPositive() {
        assertThrows(RecipeException.class, () -> r1.setAmtChocolate(-1 + ""));
    }

    @Test
    public void checkChocolateIsNotNull() {
        assertThrows(RecipeException.class, () -> r1.setAmtChocolate("null"));
    }


    @Test
    public void checkSugarIsPositive() {
        assertThrows(RecipeException.class, () -> r1.setAmtSugar(-1 + ""));
    }

    @Test
    public void checkSugarIsNotNull() {
        assertThrows(RecipeException.class, () -> r1.setAmtCoffee("null"));
    }

    @Test
    public void checkCoffeeIsPositive() {
        assertThrows(RecipeException.class, () -> r1.setAmtCoffee("-1"));
    }

    @Test
    public void checkCoffeeIsNotNull() {
        assertThrows(RecipeException.class, () -> r1.setAmtCoffee("null"));
    }

    @Test
    public void testSetAmtCoffeeEmptyInput() {
        assertThrows(RecipeException.class, () -> r1.setAmtCoffee(""));
    }


    @Test
    public void testGetPrice() {
        assertEquals(66, r1.getPrice());

    }

    @Test
    public void checkPriceIsPositive() {
        assertThrows(RecipeException.class, () -> r1.setPrice("-1"));
    }


    @Test
    public void checkPriceIsNotString() {
        assertThrows(RecipeException.class, () -> r1.setPrice("BC"));
    }


    @Test
    public void testSetPrice() {
        try {
            r1.setPrice("50");
            assertEquals(50, r1.getPrice());
            System.out.println(r1.getPrice());
        } catch (RecipeException e) {
            fail("Recipe exception should not be thrown");
        }
    }

    @Test
    public void testPriceNoInput() {
        assertThrows(RecipeException.class, () -> r1.setPrice(""));
    }

    @Test
    public void testGetAmtSugar() {
        assertEquals(1, r1.getAmtSugar());

    }

    @Test
    public void testSetAmtSugar() {
        try {
            r1.setAmtSugar("6");
            assertEquals(6, r1.getAmtSugar());
            System.out.println(r1.getAmtSugar());
        } catch (RecipeException e) {
            fail("Recipe exception should not be thrown");
        }

    }

    @Test
    public void testSetAmtSugarInvalid() {
        assertThrows(RecipeException.class, () -> r1.setAmtSugar("Hehe"));
    }

    @Test
    public void testGetAmtCoffee() {
        assertEquals(3, r1.getAmtCoffee());
    }

    @Test
    public void testCoffeeIsNegative() {
        assertThrows(RecipeException.class, () -> r1.setAmtCoffee(-1 + ""));
    }


    @Test
    public void testSetAmtCoffee() {
        try {
            r1.setAmtCoffee("4");
            assertEquals(4, r1.getAmtCoffee());
            System.out.println(r1.getAmtCoffee());
        } catch (RecipeException e) {
            fail("You have received a recipe exception");
        }
    }


    @Test
    public void testGetAmtChocolate() {
        assertEquals(3, r1.getAmtCoffee());
    }


    @Test
    public void testSetAmtChocolate() {
        try {
            r1.setAmtChocolate("10");
            assertEquals(10, r1.getAmtChocolate());
        } catch (RecipeException e) {
            fail("You have received a recipe exception");
        }
    }

    @Test
    public void testSetAmtChocolateInvalid() {
        assertThrows(RecipeException.class, () -> r1.setAmtChocolate("ABC"));
    }

    @Test
    public void testChocolateNoInput() {
        assertThrows(RecipeException.class, () -> r1.setAmtChocolate(""));
    }

    @Test
    public void testGetAmtMilk() {
        assertEquals(1, r1.getAmtMilk());
    }

    @Test
    public void testSetAmtMilk() {
        try {
            r1.setAmtMilk("6");
            assertEquals(6, r1.getAmtMilk());
            System.out.println(r1.getAmtMilk());
        } catch (RecipeException e) {
            fail("You have received a recipe exception");
        }
    }

    @Test
    public void testMilkIsNegative() {
        assertThrows(RecipeException.class, () -> r1.setAmtMilk("-1"));
    }

    @Test
    public void testMilkIsNoInput() {
        assertThrows(RecipeException.class, () -> r1.setAmtMilk(""));
    }

    @Test
    public void testSetName() {
        r1.setName("name");
        assertEquals("name", r1.getName());
    }

    @Test
    public void testToString() {
        assertEquals(r1.getName(), r1.toString());
    }

    @Test
    public void testHashCode() {
        assertTrue(r1.hashCode() == r2.hashCode());
        assertTrue(r1.equals(r2) && r2.equals(r1));
    }

    @Test
    public void testEqualsValid() throws RecipeException {

        Recipe r3 = new Recipe();
        r3.setName("name");
        r3.setAmtChocolate("0");
        r3.setAmtCoffee("3");
        r3.setAmtMilk("1");
        r3.setAmtSugar("1");
        r3.setPrice("66");
        assertEquals(r1, r3);

        r2 = r1;
        assertEquals(r1, r2);
    }

    @Test
    public void testEqualsNull() {
        r2 = null;
        assertFalse(r1.equals(r2));
    }

    @Test
   public void testEqualsReturnFalse(){
        r2.setName("Latte");
        assertFalse(r1.equals(r2));
    }

    @Test // Testing
   public void testEqualsGetClass() {

        Inventory inv = new Inventory();
        assertFalse(r1.equals(inv));
    }
}

