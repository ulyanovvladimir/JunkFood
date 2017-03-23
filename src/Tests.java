import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {
    @Test
    public void test1_2meal() {
        String title = "meal11";
        Float price = 10.5F;
        Meal m = new Meal(title, price);
        assertEquals(title, m.getTitle());
        assertEquals(price, m.getPrice());
    }
    @Test(expected = UnsupportedOperationException.class)
    public void test1_2meal1() {
        String title = "meal12";
        Float price = 16F;
        Meal m = new Meal(title, price);
        m.altTitle("meeaaal");
        m.altPrice(0F);
    }

    @Test
    public void test3menu() {
        Menu menu = new Menu();
        assertNotNull(menu.list());
        assertTrue(menu.list().size() >= 10);
        assertEquals(menu.list(), menu.list());
    }

    @Test
    public void test3order() {
        Menu menu = new Menu();
        Order order = new Order();
        order.addMeal(menu.list().get(0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void test3order1() {
        Order order = new Order();
        order.addMeal(new Meal("neeew",0F));
    }

    @Test
    public void test4orderprice() {
        Menu menu = new Menu();
        Order order = new Order();
        assertEquals(new Float(0), order.totalSum());
        Meal meal = menu.list().get(0);
        order.addMeal(meal);
        Float price = meal.getPrice();
        assertEquals(price,order.totalSum());
        meal = menu.list().get(1);
        order.addMeal(meal);
        price += meal.getPrice();
        assertEquals(price,order.totalSum());
    }

    @Test
    public void test5order() {
        Menu menu = new Menu();
        Order order = new Order();
        Meal meal = menu.list().get(0);
        int count = 2;
        Float price = meal.getPrice();
        Float sumpr = price*count;
        order.addMeal(meal, count);
        assertEquals(sumpr, order.totalSum());
    }
}