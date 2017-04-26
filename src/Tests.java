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
    public void test12() {
        String title = "Quesadillas";
        Float price = 80f;
        Meal meal = new Meal(title, price);
        assertEquals(title, meal.getTitle());
        assertEquals(price, meal.getPrice());
    }



    //todo Test 3 на создание меню
    //todo Проверьте, что можно создать объект класса Menu
    //todo Проверьте, что список не пуст.
    //todo Проверьте, что список состоит не менее чем из 10 блюд.
    //todo Проверьте, что меню не изменяется: метод list() возвращает один и тот же список объектов
    @Test
    public void test31() {
        Menu MenuTest = new Menu();
        Order OrderTest = new Order();
        assertEquals(new Float(0),OrderTest.totalSum());
        Float price = MenuTest.list().get(7).getPrice();
        OrderTest.addMeal(MenuTest.list().get(7), 1);
        assertEquals(price, OrderTest.totalSum());
    }
    //todo Test 3 на заказ
    //todo Проверьте, что в заказ можно добавить блюдо из меню
    //todo Проверьте, что добавить в заказ можно только блюдо из меню (иначе должно кидаться исключение IllegalArgumentException

    @Test
    public void test32() {
        Menu MenuTest = new Menu();
        Order o = new Order();
        o.addMeal(MenuTest.list().get(7), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOrder2() {
        Order o = new Order();
        o.addMeal(new Meal("Нет в меню", 10f), 1);
    }
    //todo Test 4 на цену заказа
    // todo Проверьте, что сумма пустого заказа равна 0
    // todo Проверьте, что после добавления в заказ сумма увеличилась соответственно
    // todo Проверьте, что сумма заказа считается корректно для разных тестовых наборов
    @Test
    public void test4() {
        Menu MenuTest = new Menu();
        Order OrderTest = new Order();
        int number = 2;
        OrderTest.addMeal(MenuTest.list().get(7), number);
        Float price = MenuTest.list().get(7).getPrice();
        Float total = number * price;
        assertEquals(total, OrderTest.totalSum());
    }
    //todo Test 5 на добавление нескольких блюд одного наименования
    //todo Проверьте, что можно добавить в заказ несколько блюд одного наименования
    //todo Проверьте, что сумма заказа изменилась соответственно
    @Test
    public void test5() {
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
    @Test
    public void test51() {
        // проверим для тестого набора подсчет суммы
        Menu MenuTest = new Menu();
        Order OrderTest = new Order();
        int number1 = 2;
        OrderTest.addMeal(MenuTest.list().get(0), number1);
        int number2 = 1;
        OrderTest.addMeal(MenuTest.list().get(3), number2);
        int number3 = 5;
        OrderTest.addMeal(MenuTest.list().get(5), number3);
        Float price1 = MenuTest.list().get(0).getPrice();
        Float price2 = MenuTest.list().get(3).getPrice();
        Float price3 = MenuTest.list().get(5).getPrice();
        Float total = number1 * price1 + number2 * price2 + number3 * price3;
        assertEquals(total, OrderTest.totalSum());
    }
}
