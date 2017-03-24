import java.util.ArrayList;
import java.util.List;

/**
 *
 * Меню. Список блюд
 *
 */
public class Menu {


    /**
     * Возвращает список блюд в меню.
     * Должен быть неизменяемым. @see Collections.unmodifiableList
     * Должен возвращать одну и ту же коллекцию объектов при кажом вызове.
     * @return список блюд в меню
     */
    static List<Meal> m;
    public Menu(){
        m =new ArrayList<>();
        m.add(new Meal("Soup",4.2f));
        m.add(new Meal("Soup2",5.2f));
        m.add(new Meal("Soup3",6.6f));
        m.add(new Meal("Soup4",7.2f));
        m.add(new Meal("Soup5",3.3f));
        m.add(new Meal("Chicken",5.2f));
        m.add(new Meal("Chicken2",8.6f));
        m.add(new Meal("Chicken3",9.1f));
        m.add(new Meal("Chicken4",1.6f));
        m.add(new Meal("Chicken5",3.0f));
    }


    public static List<Meal> list(){
        return m;
    }


}
