import org.junit.Before;
import org.junit.Test;

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
    @Test
    public void testExample(){
        //Проверка на истину булевого выражения
        assertTrue("Это все знают! Да или нет?!", 2+2 == 4);
        //Проверка на равенство объектов. Объекты сравниваются методом @see Object.equals
        assertEquals(new Integer(10), new Integer(10));
        //Проверка на неравенство. Да! 10 и "10" не равны. Это вам не JavaScript ;)
        assertNotEquals(10, "10");
        //Проверка на не пустоту
        assertNotNull(new Tests());
        //Проверка на пустоту
        assertNull(null);
        //Order создан, заранее заготовлен в методе prepare. Проверим его на не пустоту. Отрабатывает ли prepare???
        assertNotNull(o);
    }


    /**
     * Этот тест всегда проваливается. Пример реакции системы Unit Testing в случае некорректной реализации.
     * Эмулируется ошибка. На вход заведомо подаются некорректные данные.
     */
    @Test
    public void testFail() {
        assertTrue("Это все знают! Да или нет?!", 2+2 == 5);
        assertEquals(new Integer(10), "10");
        assertNull(new Tests());
    }

    /*
        Тест проверяет кидание исключения IllegalArgumentException в случае, если в заказ добавляется что-то не из Меню.

    @Test(expected= IllegalArgumentException.class)
    public void testNotInPrice(){
        new Order().addMeal(new Meal());
    }
*/
    //-------------------------Ваши тесты --------------------------------



    @Test
    public void test1() {
        String title = "Chicken";
        Float price = 8.2f;
        Meal ml = new Meal(title, price);
        assertEquals("Ttl",title, ml.getTitle());
    }


    @Test
    public void test2() {
        String title = "Chicken";
        Float price = 8.2f;
        Meal ml = new Meal(title, price);
        assertEquals("Pr",price, ml.getPrice());
    }


    @Test
    public void test3() {
        Menu menu = new Menu();
        assertNotNull(menu.list());
        assertTrue(menu.list().size() >= 10);
        assertEquals(menu.list(),menu.list());
    }


//fix
    @Test
    public void test3Order() {
        Menu menu = new Menu();
        Order o = new Order();
        o.addMeal(menu.list().get(2));
    }

//fix
    @Test(expected= IllegalArgumentException.class)
    public void test3OrderIllegal(){
        Order o = new Order();
        o.addMeal(new Meal("Chicken10",100F));
    }


    @Test
    public void test4(){
        Menu menu = new Menu();
        Order o = new Order();
        assertEquals(new Float(0), o.totalSum());
        Float presentprice=o.totalSum();
        o.addMeal(menu.list().get(2));
        Float newPrice = presentprice+ menu.list().get(2).getPrice();
        assertEquals(newPrice,o.totalSum());
        o.addMeal(menu.list().get(8));
        newPrice=newPrice+menu.list().get(8).getPrice();
        assertEquals(newPrice, o.totalSum());
    }



    //todo Test 5 на добавление нескольких блюд одного наименования
    //todo Проверьте, что можно добавить в заказ несколько блюд одного наименования
    //todo Проверьте, что сумма заказа изменилась соответственно
    @Test
    public void test5(){
        Menu menu = new Menu();
        Order o = new Order();
        o.addMeal(menu.list().get(2),2);
        o.addMeal(menu.list().get(5),3);
        Float newPrice = menu.list().get(2).getPrice()*2+menu.list().get(5).getPrice()*3;
        assertEquals(newPrice,o.totalSum());
    }
}
