import org.junit.Ignore;
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
//    @Before
//    @Ignore
//    public void preparation(){
//        o = new Order();
//        List<Meal> menuList = new Menu().list();
//        if (!menuList.isEmpty()) {
//            o.addMeal(menuList.get(0));
//        }
//    }

    /**
     * Демонстрирует базовые возможности библиотеки тестирования JUnit.
     * Можно задавать несколько видов тестов.
     */
    @Test
    @Ignore
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
    @Ignore
    public void testFail() {
        assertTrue("Это все знают! Да или нет?!", 2+2 == 5);
        assertEquals(new Integer(10), "10");
        assertNull(new Tests());
    }

    /*
        Тест проверяет кидание исключения IllegalArgumentException в случае, если в заказ добавляется что-то не из Меню.
    */
    @Test(expected= IllegalArgumentException.class)
    public void testNotInPrice(){
        new Order().addMeal(new Meal("car",1),22);
    }

    //-------------------------Ваши тесты --------------------------------



    //todo Test 1 на блюдо
    //todo Проверьте чтобы можно было создать блюдо с указанием его наименования
    //todo Указать наименование при создании можно, изменить нельзя.
    //todo Возвращаемое значение должно совпадать с тем наименованием, что было указано при создании
    @Test
    public void test1(){
        String someOne = "someOne";
        double price = 1213.24;
        Meal meal = new Meal(someOne,price);
        assertEquals(someOne,meal.getTitle());
    }




    //todo Test 2 на блюдо
    //todo Проверьте чтобы можно было создать блюдо с указанием его цены
    //todo Проверьте, что указать цену при создании можно, изменить нельзя.
    //todo Проверьте, что возвращаемое значение должно совпадать с тем, что было указано при создании
    @Test
    public void test2(){
        String someOne = "someOne";
        double price = 1213.24;
        Meal meal = new Meal(someOne,price);
        assertTrue(price==meal.getPrice());

    }

    //todo Test 3 на создание меню
    //todo Проверьте, что можно создать объект класса Menu
    //todo Проверьте, что список не пуст.
    //todo Проверьте, что список состоит не менее чем из 10 блюд.
    //todo Проверьте, что меню не изменяется: метод list() возвращает один и тот же список объектов
    @Test
    public void test3(){
        Menu menu = new Menu();
        menu.create();
        assertNotNull(menu.list());
        assertTrue(menu.list().size()>=10);
        assertEquals(menu.list(),menu.list());
    }


    //todo Test 3 на заказ
    //todo Проверьте, что в заказ можно добавить блюдо из меню
    //todo Проверьте, что добавить в заказ можно только блюдо из меню (иначе должно кидаться исключение IllegalArgumentException
    @Test
    public void test3_5(){
        Menu menu = new Menu();
        menu.create();
        Meal meal2 = menu.list().get(1);
        Order order = new Order();
        order.addMeal(meal2,1);
    }
    @Test(expected= IllegalArgumentException.class)
    public void test3_5_5(){
        Meal meal1 = new Meal("asdasd",15.18);
        Order order = new Order();
        order.addMeal(meal1,1);
    }
    //todo Test 4 на цену заказа
    // todo Проверьте, что сумма пустого заказа равна 0
    // todo Проверьте, что после добавления в заказ сумма увеличилась соответственно
    // todo Проверьте, что сумма заказа считается корректно для разных тестовых наборов
    @Test
    public void test4(){
        Order order = new Order();
        double sum = (double) order.totalSum();
        assertTrue(sum==0);
        Menu menu = new Menu();
        menu.create();
        Meal meal = menu.list().get(1);
        assertTrue(meal.getPrice() != 0);
        order.addMeal(meal,1);
        double sum1 = (double) order.totalSum();
        assertTrue(sum1==sum+meal.getPrice());
    }

    //todo Test 5 на добавление нескольких блюд одного наименования
    //todo Проверьте, что можно добавить в заказ несколько блюд одного наименования
    //todo Проверьте, что сумма заказа изменилась соответственно
    @Test
    public void test5(){
        Menu menu = new Menu();
        menu.create();
        Meal meal = menu.list().get(4);
        Order order = new Order();
        assertTrue(meal.getPrice() !=0);
        order.addMeal(meal,4);
        assertTrue(order.totalSum()==4*meal.getPrice());

    }
    // В меню два одинаковых блюда с разными ценами
    @Test
    public void test6(){
        Menu menu = new Menu();
        menu.create();
        List<Meal> list = menu.list();
        for (int i = 0;i<list.size();i++){
            for (int y = 0;y<list.size();y++){
                if (i != y){
                    assertFalse(list.get(i).equals(list.get(y)));
                }
            }
        }

    }

}
