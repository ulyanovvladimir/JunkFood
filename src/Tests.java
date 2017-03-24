import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;


public class Tests {

    @Test
    public void testMeal(){
        String title = "Пицца";
        Float price = 80F;
        Meal MealTest = new Meal(title, price);
        assertEquals(title, MealTest.getTitle());
        assertEquals(price, MealTest.getPrice());
    }

    @Test
    public void testMenu() {
        Menu MenuTest = new Menu();
        assertNotNull(MenuTest.list());
        assertTrue(MenuTest.list().size() >= 5);
        assertEquals(MenuTest.list(),MenuTest.list());
    }

    @Test
    public void testOrder1() {
        Menu MenuTest = new Menu();
        Order o = new Order();
        o.addMeal(MenuTest.list().get(7), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOrder2() {
        Order o = new Order();
        o.addMeal(new Meal("Не входит в меню", 10f), 1);
    }

    @Test
    public void testOrderPrice1() {
        Menu MenuTest = new Menu();
        Order OrderTest = new Order();
        assertEquals(new Float(0),OrderTest.totalSum());
        Float price = MenuTest.list().get(7).getPrice();
        OrderTest.addMeal(MenuTest.list().get(7), 1);
        assertEquals(price, OrderTest.totalSum());
    }

    @Test
    public void testPriceOrder2() {
        Menu MenuTest = new Menu();
        Order OrderTest = new Order();
        int number = 2;
        OrderTest.addMeal(MenuTest.list().get(7), number);
        Float price = MenuTest.list().get(7).getPrice();
        Float total = number * price;
        assertEquals(total, OrderTest.totalSum());
    }

    @Test
    public void testPriceOrder3() {
        Menu MenuTest = new Menu();
        Order OrderTest = new Order();
        int number1 = 2;
        OrderTest.addMeal(MenuTest.list().get(0), number1);
        int number2 = 1;
        OrderTest.addMeal(MenuTest.list().get(3), number2);
        Float price1 = MenuTest.list().get(0).getPrice();
        Float price2 = MenuTest.list().get(3).getPrice();
        Float total = number1 * price1 + number2 * price2;
        assertEquals(total, OrderTest.totalSum());
    }

}