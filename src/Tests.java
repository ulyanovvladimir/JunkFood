import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * ТЕСТЫ!!! TestDrivenDevelopment rules!!!
 */


public class Tests {
    Order o=null;

    /**
     * Этот метод подготовительный. Он всегда вызывается перед запуском любого теста или пачки тестов.
     * В нем удобно подготавливать (prepare) объекты, которые будут подвергаться множеству тестов. Например, подключить тестовую базу данных.
     *
     * В нашем случае показан пример создания заказа, состоящего из первого блюда списка блюд нашего меню.
     */


    /**
     * Демонстрирует базовые возможности библиотеки тестирования JUnit.
     * Можно задавать несколько видов тестов.
     */



    //todo Test 1 на блюдо
    //todo Проверьте чтобы можно было создать блюдо с указанием его наименования
    //todo Указать наименование при создании можно, изменить нельзя.
    //todo Возвращаемое значение должно совпадать с тем наименованием, что было указано при создании


    //todo Test 2 на блюдо
    //todo Проверьте чтобы можно было создать блюдо с указанием его цены
    //todo Проверьте, что указать цену при создании можно, изменить нельзя.
    //todo Проверьте, что возвращаемое значение должно совпадать с тем, что было указано при создании

    @Test
    public void testMealCreation() {
        String title = "soup";
        Float price = 10.5f;
        Meal meal = new Meal(title, price);
        assertEquals(title, meal.getTitle());
        assertEquals(price, meal.getPrice());
    }

    @Test
    public void testEqualTitledMealsEquality() {
        Meal meal1 = new Meal("salad", 10f);
        Meal meal2 = new Meal("salad", 12f);
        assertEquals(meal1,meal2);
    }
    //todo Test 3 на создание меню
    //todo Проверьте, что можно создать объект класса Menu
    //todo Проверьте, что список не пуст.
    //todo Проверьте, что список состоит не менее чем из 10 блюд.
    //todo Проверьте, что меню не изменяется: метод list() возвращает один и тот же список объектов

    @Test
    public void testMenuCreation() {
        Menu menu = new Menu();
        assertNotNull(menu.list());
        assertTrue(menu.list().size() >= 10);
        assertEquals(menu.list(),menu.list());
    }

    //todo Test 3 на заказ
    //todo Проверьте, что в заказ можно добавить блюдо из меню
    //todo Проверьте, что добавить в заказ можно только блюдо из меню (иначе должно кидаться исключение IllegalArgumentException

    @Test
    public void testAddingMealFromMenuToOrder() {
        o = new Order();
        Menu menu = new Menu();
        o.addMeal(menu.list().get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingMealNotFromMenuToOrder() {
        o = new Order();
        o.addMeal(new Meal("chicken", 16.5f));
    }

    //todo Test 4 на цену заказа
    // todo Проверьте, что сумма пустого заказа равна 0
    // todo Проверьте, что после добавления в заказ сумма увеличилась соответственно
    // todo Проверьте, что сумма заказа считается корректно для разных тестовых наборов

    @Test
    public void testPriceOfTheOrder() {
        Order order = new Order();
        Menu menu = new Menu();
        assertEquals(new Float(0), order.totalSum());
        Float price = menu.list().get(0).getPrice();
        order.addMeal(menu.list().get(0));
        assertEquals(price,order.totalSum());
        Order order1 = new Order();
        Float price1 = menu.list().get(1).getPrice() + menu.list().get(2).getPrice();
        order1.addMeal(menu.list().get(1));
        order1.addMeal(menu.list().get(2));
        assertEquals(price1, order1.totalSum());
    }
    //todo Test 5 на добавление нескольких блюд одного наименования
    //todo Проверьте, что можно добавить в заказ несколько блюд одного наименования
    //todo Проверьте, что сумма заказа изменилась соответственно

    @Test
    public void testPriceOfTheOrderWithRepeatingMeals() {
        Order order = new Order();
        Menu menu = new Menu();
        Float price = menu.list().get(2).getPrice();
        int count = 5;
        Float sum = price*count;
        order.addMeal(menu.list().get(2),count);
        assertEquals(sum,order.totalSum());
    }

    @Test
    public void testNoRepeatingMealsInMenu() {
        Menu menu = new Menu();
        List<Meal> list = menu.list();
        List<Meal> listTemp = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < list.size();i++){
            if (!listTemp.contains(list.get(i))){
                listTemp.add(list.get(i));
            } else {
                flag = true;
                break;
            }
        }
        assertFalse(flag);
    }
}
