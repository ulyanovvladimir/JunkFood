import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
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
    @Before
    public void preparation(){
        o = new Order();
        List<Meal> menuList = new Menu().list();
        if (!menuList.isEmpty()) {
            o.addMeal(menuList.get(0));
        }
    }

    /**
     * Демонстрирует базовые возможности библиотеки тестирования JUnit.
     * Можно задавать несколько видов тестов.
     */
    // @Test
    // public void testExample(){
    //Проверка на истину булевого выражения
    //    assertTrue("Это все знают! Да или нет?!", 2+2 == 4);
    //Проверка на равенство объектов. Объекты сравниваются методом @see Object.equals
    //    assertEquals(new Integer(10), new Integer(10));
    //Проверка на неравенство. Да! 10 и "10" не равны. Это вам не JavaScript ;)
    //   assertNotEquals(10, "10");
    //Проверка на не пустоту
    //   assertNotNull(new Tests());
    //Проверка на пустоту
    //  assertNull(null);
    //Order создан, заранее заготовлен в методе prepare. Проверим его на не пустоту. Отрабатывает ли prepare???
    //  assertNotNull(o);
    //   }


    /**
     * Этот тест всегда проваливается. Пример реакции системы Unit Testing в случае некорректной реализации.
     * Эмулируется ошибка. На вход заведомо подаются некорректные данные.
     */
    //  @Test
    //   public void testFail() {
    //      assertTrue("Это все знают! Да или нет?!", 2+2 == 5);
    //      assertEquals(new Integer(10), "10");
    //      assertNull(new Tests());
    // }

    //-------------------------Ваши тесты --------------------------------



    //todo Test 1 на блюдо
    //todo Проверьте чтобы можно было создать блюдо с указанием его наименования
    //todo Указать наименование при создании можно, изменить нельзя.
    //todo Возвращаемое значение должно совпадать с тем наименованием, что было указано при создании


    //todo Test 2 на блюдо
    //todo Проверьте чтобы можно было создать блюдо с указанием его цены
    //todo Проверьте, что указать цену при создании можно, изменить нельзя.
    //todo Проверьте, что возвращаемое значение должно совпадать с тем, что было указано при создании
    @Test
    public void test1_2() {
        String title = "NewMeal";
        Float price = 100f;
        Meal meal1 = new Meal(title, price);
        assertEquals(title, meal1.getTitle());
        assertEquals(price, meal1.getPrice());

        Meal meal2 = new Meal(title, 150f);
        assertEquals(meal1, meal2);
    }



    //todo Test 3 на создание меню
    //todo Проверьте, что можно создать объект класса Menu
    //todo Проверьте, что список не пуст.
    //todo Проверьте, что список состоит не менее чем из 10 блюд.
    //todo Проверьте, что меню не изменяется: метод list() возвращает один и тот же список объектов

    @Test
    public void test3_creation() {
        Menu menu = new Menu();
        assertNotNull(menu.list());
        assertTrue(menu.list().size() >= 10);
        assertEquals(menu.list(),menu.list());
    }


    //todo Test 3 на заказ
    //todo Проверьте, что в заказ можно добавить блюдо из меню
    //todo Проверьте, что добавить в заказ можно только блюдо из меню (иначе должно кидаться исключение IllegalArgumentException

    @Test
    public void test3_order() {
        Menu menu = new Menu();
        Order o = new Order();
        Meal meal = menu.list().get(0);
        o.addMeal(meal);
        o.addMeal(meal, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotFromMenu() {
        Order o = new Order();
        o.addMeal(new Meal("Byaka", 111f));
        o.addMeal(new Meal("Byaka", 111f), 2);
    }


    //todo Test 4 на цену заказа
    // todo Проверьте, что сумма пустого заказа равна 0
    // todo Проверьте, что после добавления в заказ сумма увеличилась соответственно
    // todo Проверьте, что сумма заказа считается корректно для разных тестовых наборов
    @Test
    public void test4() {
        Menu menu = new Menu();
        Order order = new Order();
        assertEquals(new Float(0), order.totalSum());

        order.addMeal(menu.list().get(0));
        Float price = menu.list().get(0).getPrice();
        Float total = price;
        assertEquals(price, order.totalSum());

        order.addMeal(menu.list().get(1));
        price = menu.list().get(1).getPrice();
        total += price;
        assertEquals(total, order.totalSum());

        order.addMeal(menu.list().get(2));
        price = menu.list().get(2).getPrice();
        total += price;
        assertEquals(total, order.totalSum());
    }


    //todo Test 5 на добавление нескольких блюд одного наименования
    //todo Проверьте, что можно добавить в заказ несколько блюд одного наименования
    //todo Проверьте, что сумма заказа изменилась соответственно
    @Test

    public void test5() {
        Menu menu = new Menu();
        Order order = new Order();

        order.addMeal(menu.list().get(0), 2);
        Float price = menu.list().get(0).getPrice();
        Float total = price*2;
        assertEquals(total, order.totalSum());

        order.addMeal(menu.list().get(0));
        price = menu.list().get(0).getPrice();
        total += price;
        assertEquals(total, order.totalSum());

        order.addMeal(menu.list().get(2), 3);
        price = menu.list().get(2).getPrice();
        total += price*3;
        assertEquals(total, order.totalSum());

        order.addMeal(menu.list().get(2));
        price = menu.list().get(2).getPrice();
        total += price;
        assertEquals(total, order.totalSum());
    }

}
