import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * ТЕСТЫ!!! TestDrivenDevelopment rules!!!
 */


public class Tests {

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

    public void testMeal(){
        String title = "Чай";
        Float price = 15F;
        // создание блюда
        Meal MealTest = new Meal(title, price);
        // проверка на равенство указанного и добавленного
        assertEquals(title, MealTest.getTitle());
        assertEquals(price, MealTest.getPrice());
    }



    //todo Test 3 на создание меню
    //todo Проверьте, что можно создать объект класса Menu
    //todo Проверьте, что список не пуст.
    //todo Проверьте, что список состоит не менее чем из 10 блюд.
    //todo Проверьте, что меню не изменяется: метод list() возвращает один и тот же список объектов

    @Test
    public void testMenu() {
        // создание
        Menu MenuTest = new Menu();
        // проверка на непустоту
        assertNotNull(MenuTest.list());
        // больше 10?
        assertTrue(MenuTest.list().size() >= 10);
        // не изменяется?
        assertEquals(MenuTest.list(),MenuTest.list());
    }

    //todo Test 4 на заказ
    //todo Проверьте, что в заказ можно добавить блюдо из меню
    //todo Проверьте, что добавить в заказ можно только блюдо из меню (иначе должно кидаться исключение IllegalArgumentException
    @Test
    public void testOrder1() {
        // добавляем блюдо из меню
        Menu MenuTest = new Menu();
        Order o = new Order();
        o.addMeal(MenuTest.list().get(7), 1F);
    }

    @Test(expected = IllegalArgumentException.class)
   public void testOrder2() {
            // если добавляется блюдо не из меню
            Order o = new Order();
            o.addMeal(new Meal("Не из меню", 10.5f), 1F);
        }

    //todo Test 5 на цену заказа
    // todo Проверьте, что сумма пустого заказа равна 0
    // todo Проверьте, что после добавления в заказ сумма увеличилась соответственно
    // todo Проверьте, что сумма заказа считается корректно для разных тестовых наборов

    @Test
    public void testOrderPrice1() {
                Menu MenuTest = new Menu();
        // создаем пустой заказ, проверяем, что сумма равна нулю
                Order OrderTest = new Order();
                assertEquals(new Float(0),OrderTest.totalSum());
        // добавляем новое блюдо, проверяем увеличение суммы
                Float price = MenuTest.list().get(7).getPrice();
                OrderTest.addMeal(MenuTest.list().get(7), 1F);
                assertEquals(price, OrderTest.totalSum());
            }

    //todo Test 6 на добавление нескольких блюд одного наименования
    //todo Проверьте, что можно добавить в заказ несколько блюд одного наименования
    //todo Проверьте, что сумма заказа изменилась соответственно

    @Test
    public void testPriceOrder2() {
                Menu MenuTest = new Menu();
        // вместе с блюдом в заказ добавляем количество
                Order OrderTest = new Order();
                Float number = 2F;
                OrderTest.addMeal(MenuTest.list().get(7), number);
                Float price = MenuTest.list().get(7).getPrice();
                Float total = number * price;
                assertEquals(total, OrderTest.totalSum());
            }

    @Test
    public void testPriceOrder3() {
        // проверим для тестого набора подсчет суммы
        Menu MenuTest = new Menu();
        Order OrderTest = new Order();
        Float number1 = 2F;
        OrderTest.addMeal(MenuTest.list().get(0), number1);
        Float number2 = 1F;
        OrderTest.addMeal(MenuTest.list().get(3), number2);
        Float number3 = 5F;
        OrderTest.addMeal(MenuTest.list().get(5), number3);
        Float price1 = MenuTest.list().get(0).getPrice();
        Float price2 = MenuTest.list().get(3).getPrice();
        Float price3 = MenuTest.list().get(5).getPrice();
        Float total = number1 * price1 + number2 * price2 + number3 * price3;
        assertEquals(total, OrderTest.totalSum());
    }

}
