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
        list.add(new Meal("Pasta",120f));
        list.add(new Meal("Tacos",60f));
        list.add(new Meal("Burrito",70f));
        list.add(new Meal("Enchilada",100f));
        list.add(new Meal("Chipotle", 5f));
        list.add(new Meal("Fajita",100f));
        list.add(new Meal("Tamale",50f));
        list.add(new Meal("Sangrita",30f));
        list.add(new Meal("Mexican tomato soup",70f));
        list.add(new Meal("Falafel",60f));
        list.add(new Meal("Guacamole",40f));
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
