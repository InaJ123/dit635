package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * Example Unit tests for INVENTORY class.
 */
public class InventoryTest {

    private Inventory inventory;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;
    private Recipe r5;


    @Before
    public void setUp() throws Exception {
        inventory = new Inventory();

        //Set up for r1
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("1");
        r1.setAmtCoffee("20");
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

        //Set up for r3
        r3 = new Recipe();
        r3.setName("Latte");
        r3.setAmtChocolate("0");
        r3.setAmtCoffee("3");
        r3.setAmtMilk("18");
        r3.setAmtSugar("1");
        r3.setPrice("100");

        //Set up for r4
        r4 = new Recipe();
        r4.setName("Hot Chocolate");
        r4.setAmtChocolate("4");
        r4.setAmtCoffee("0");
        r4.setAmtMilk("10");
        r4.setAmtSugar("1");
        r4.setPrice("65");

        //Set up for r4
        r5 = new Recipe();
        r5.setName("Hot milk");
        r5.setAmtChocolate("4");
        r5.setAmtCoffee("0");
        r5.setAmtMilk("20");
        r5.setAmtSugar("1");
        r5.setPrice("65");
    }

    @Test
    public void getInventoryTest() {
        inventory.setChocolate(2);
        inventory.setCoffee(4);
        inventory.setMilk(5);
        inventory.setSugar(8);

        String actual = "Coffee: 4\nMilk: 5\nSugar: 8\nChocolate: 2\n";
        String expected = inventory.toString();
        assertEquals(expected, actual);
    }

    // add ingredients testing methods

    @Test
    public void addCoffeeTest() {
        try {
            inventory.addCoffee("5");
        } catch (InventoryException e) {
            fail("InventoryException should not be thrown");
        }
        int actual = inventory.getCoffee();
        int expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    public void addSugarTest() {
        try {
            inventory.addSugar("5");
        } catch (InventoryException e) {
            fail("InventoryException should not be thrown");
        }
        int actual = inventory.getSugar();
        int expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    public void addMilkTest() {
        try {
            inventory.addMilk("10");
        } catch (InventoryException e) {
            fail("InventoryException should not be thrown");
        }
        int actual = inventory.getMilk();
        int expected = 25;
        assertEquals(expected, actual);
    }

    @Test
    public void addChoclateTest() {
        try {
            inventory.addChocolate("2");
        } catch (InventoryException e) {
            fail("InventoryException should not be thrown");
        }
        int actual = inventory.getChocolate();
        int expected = 17;
        assertEquals(expected, actual);
    }

    ///////////////////////////////////////
    ////checking right input tests/////////
    ///////////////////////////////////////

    @Test
    public void addCoffeeNotNumberTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addCoffee("a");
        });
        assertEquals("Units of coffee must be a positive integer", exception.getMessage());

    }

    @Test
    public void addSugarNotNumberTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addSugar("KO");
        });
        assertEquals("Units of sugar must be a positive integer", exception.getMessage());

    }

    @Test
    public void addMilkNotNumberTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addMilk("L8");
        });
        assertEquals("Units of milk must be a positive integer", exception.getMessage());

    }

    @Test
    public void addChoclateNotNumberTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addChocolate("LP");
        });
        assertEquals("Units of chocolate must be a positive integer", exception.getMessage());

    }

    ///////////////////////////////////////
    ////checking not decimal tests/////////
    ///////////////////////////////////////

    @Test
    public void addCoffeeNotDecimalNumberTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addCoffee("1.55");
        });
        assertEquals("Units of coffee must be a positive integer", exception.getMessage());

    }

    @Test
    public void addSugarNotDecimalNumberTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addSugar("5.65");
        });
        assertEquals("Units of sugar must be a positive integer", exception.getMessage());

    }

    @Test
    public void addMilkNotDecimalNumberTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addMilk("45.6");
        });
        assertEquals("Units of milk must be a positive integer", exception.getMessage());

    }

    @Test
    public void addChoclateNotDecimalNumberTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addChocolate("8.6");
        });
        assertEquals("Units of chocolate must be a positive integer", exception.getMessage());

    }

    ///////////////////////////////////////
    ////checking not negative tests////////
    ///////////////////////////////////////

    @Test
    public void addCoffeeNotNegativeNumberTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addCoffee("-2");
        });
        assertEquals("Units of coffee must be a positive integer", exception.getMessage());

    }

    @Test
    public void addSugarNotNegativeNumberTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addSugar("-100");
        });
        assertEquals("Units of sugar must be a positive integer", exception.getMessage());

    }

    @Test
    public void addMilkNotNegativeNumberTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addMilk("-99");
        });
        assertEquals("Units of milk must be a positive integer", exception.getMessage());

    }

    @Test
    public void addChocolateNotNegativeNumberTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addChocolate("-43");
        });
        assertEquals("Units of chocolate must be a positive integer", exception.getMessage());

    }

    ///////////////////////////////////////
    //////checking not empty tests/////////
    ///////////////////////////////////////

    @Test
    public void addCoffeeEmptyTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addCoffee("");
        });
        assertEquals("Units of coffee must be a positive integer", exception.getMessage());

    }

    @Test
    public void addSuagrEmptyTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addSugar("");
        });
        assertEquals("Units of sugar must be a positive integer", exception.getMessage());

    }

    @Test
    public void addMilkEmptyTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addMilk("");
        });
        assertEquals("Units of milk must be a positive integer", exception.getMessage());

    }

    @Test
    public void addChcolateEmptyTest() {
        Throwable exception = assertThrows(InventoryException.class, () -> {
            inventory.addChocolate(""); // Should throw an InventoryException
        });
        assertEquals("Units of chocolate must be a positive integer", exception.getMessage());

    }
    ///////////////////////////////////////
    ////checking Ingredient tests/////////
    ///////////////////////////////////////
    @Test
    public void useIngredientTest() {
        boolean actual = inventory.useIngredients(r4);
        assertTrue(actual, "failure");

    }
    @Test
    public void useIngredientNotEnoughTest() {
        boolean actual = inventory.useIngredients(r2);
        assertFalse(actual, "failure");

    }

    ///////////////////////////////////////
    ////checking ENOUGH Ingredient tests///
    ///////////////////////////////////////

    @Test
    public void enoughIngrediantTest() {
        boolean actual = inventory.enoughIngredients(r4);
        boolean expected = true;
        assertEquals(expected, actual);

    }

    @Test
    public void enoughIngrediantCoffeeTest(){
        boolean actual = inventory.enoughIngredients(r1) ;

        assertFalse(actual, "fail, not enough coffee");
    }

    @Test
    public void enoughIngrediantChocolateTest(){
        boolean actual = inventory.enoughIngredients(r2) ;

        assertFalse(actual, "fail, not enough chocolate");
    }

    @Test
    public void enoughIngrediantMilkTest(){
        boolean actual = inventory.enoughIngredients(r3) ;

        assertFalse(actual, "fail, not enough milk");
    }

    @Test
    public void enoughIngrediantSugarTest(){
        boolean actual = inventory.enoughIngredients(r5) ;

        assertFalse(actual, "fail, not enough sugar");
    }

}
