import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {
    @Test
    public void test1And2ForMeal() {
        String title = "meal11";
        Float price = 10.5F;
        Meal m = new Meal(title, price);
        assertEquals(title, m.getTitle());
        assertEquals(price, m.getPrice());
    }
    @Test(expected = UnsupportedOperationException.class)
    public void test1And2ForMealDop() {
        String title = "meal12";
        Float price = 16F;
        Meal m = new Meal(title, price);
        m.setTitle("meeaaal");
        m.setPrice(0F);
    }

    @Test
    public void test3ForMenu() {
        Menu menu = new Menu();
        assertNotNull(menu.list());
        assertTrue(menu.list().size() >= 10);
        assertEquals(menu.list(), menu.list());
    }

    @Test
    public void test3ForOrder() {
        Menu menu = new Menu();
        Order order = new Order();
        order.addMeal(menu.list().get(0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void test3ForOrderDop() {
        Order order = new Order();
        order.addMeal(new Meal("neeew",0F));
    }

    @Test
    public void test4ForOrderPrice() {
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
    public void test5ForOrder() {
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