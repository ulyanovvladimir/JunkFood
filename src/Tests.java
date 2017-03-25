import jdk.nashorn.internal.AssertsEnabled;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

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

    /*
    Тест проверяет кидание исключения IllegalArgumentException в случае, если в заказ добавляется что-то не из Меню.
    */


//-------------------------Ваши тесты —----------------------------—



    //todo Test 1 на блюдо
    @Test
    public void testOne(){
//todo Проверьте чтобы можно было создать блюдо с указанием его наименования
//todo Указать наименование при создании можно, изменить нельзя.
        assertNotNull("блюдо с указанием его наименования", new Meal("салат Цезарь",(float) 320));
//todo Возвращаемое значение должно совпадать с тем наименованием, что было указано при создании
        assertEquals("паста Болоньезе", (new Meal("паста Болоньезе",(float) 340)).getTitle());
    }



    //todo Test 2 на блюдо
    @Test
    public void testTwo(){
//todo Проверьте чтобы можно было создать блюдо с указанием его цены
//todo Проверьте, что указать цену при создании можно, изменить нельзя.
        assertNotNull("блюдо с указанием его цены", new Meal("салат Ницца",(float) 320));
//todo Проверьте, что возвращаемое значение должно совпадать с тем, что было указано при создании
        assertEquals(new Float(340), (new Meal("паста Карбонара",(float) 340)).getPrice());
    }


    //todo Test 3 на создание меню
    @Test
    public void testThreeMenu(){
//todo Проверьте, что можно создать объект класса Menu
        Menu m = new Menu();
//todo Проверьте, что список не пуст.
        assertNotNull(m.list());
//todo Проверьте, что список состоит не менее чем из 10 блюд.
        assertTrue(m.list().size() >= 10);
//todo Проверьте, что меню не изменяется: метод list() возвращает один и тот же список объектов
        assertEquals(m.list(),m.list());
    }


    //todo Test 3 на заказ
    @Test
    public void testThreeOrder() {
//todo Проверьте, что в заказ можно добавить блюдо из меню
        (new Order()).addMeal((new Menu()).list().get(0));
    }

    //todo Проверьте, что добавить в заказ можно только блюдо из меню (иначе должно кидаться исключение IllegalArgumentException
    @Test(expected= IllegalArgumentException.class)
    public void testOrder() {
        (new Order()).addMeal(new Meal("Пельмени",(float) 100),1);
    }

    //todo Test 4 на цену заказа
    @Test
    public void testFour(){
// todo Проверьте, что сумма пустого заказа равна 0
        assertEquals(new Float(0),(new Order()).totalSum());
// todo Проверьте, что после добавления в заказ сумма увеличилась соответственно
        Order o = new Order();
        Menu m = new Menu();
        assertEquals(new Float(0),o.totalSum());
        o.addMeal(m.list().get(0));
        assertEquals(m.list().get(0).getPrice(),o.totalSum());
// todo Проверьте, что сумма заказа считается корректно для разных тестовых наборов
        Order o2 = new Order();
        Menu m2 = new Menu();
        o2.addMeal(m2.list().get(0));
        o2.addMeal(m2.list().get(1));
        Float sum = new Float(m2.list().get(0).getPrice()+m2.list().get(1).getPrice());
        assertEquals(sum,o2.totalSum());

    }

    //todo Test 5 на добавление нескольких блюд одного наименования
    @Test
    public void testFive(){
//todo Проверьте, что можно добавить в заказ несколько блюд одного наименования
        Order o = new Order();
        Menu m = new Menu();
        o.addMeal(m.list().get(1),2);
//todo Проверьте, что сумма заказа изменилась соответственно
        Float sum = new Float(m.list().get(1).getPrice() * 2);
        assertEquals(sum,o.totalSum());
    }


}
