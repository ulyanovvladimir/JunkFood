import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Меню. Список блюд
 *
 */
public class Menu {
    private List<Meal> list;

    //todo Создайте свое меню. Должен быть хотя бы один конструктор, который создает объект класса Menu, содержащий список не менее чем из 10 блюд.
    //todo Должно быть не менее 10 блюд.
    //todo Список должен быть не пуст
    //todo Это намеки на создание тестов. Сначала тесты, потом реализация!


    public Menu() {
        list = new ArrayList<>();

        list.add(new Meal("Pizza",300f));
        list.add(new Meal("Pasta",130f));
        list.add(new Meal("Humburger",140f));
        list.add(new Meal("Rolls",90f));
        list.add(new Meal("Soup", 55f));
        list.add(new Meal("Shashlik",200f));
        list.add(new Meal("Fish",190f));
        list.add(new Meal("Pork",220f));
        list.add(new Meal("Rice",70f));
        list.add(new Meal("Salad",110f));
    }
    /**
     * Возвращает список блюд в меню.
     * Должен быть неизменяемым. @see Collections.unmodifiableList
     * Должен возвращать одну и ту же коллекцию объектов при кажом вызове.
     * @return список блюд в меню
     */
    public List<Meal> list(){

        return Collections.unmodifiableList(list);
    }

}
