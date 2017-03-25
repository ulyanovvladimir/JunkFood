import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Меню. Список блюд
 *
 */
public class Menu {

    static List<Meal> list;

    //todo Создайте свое меню. Должен быть хотя бы один конструктор, который создает объект класса Menu, содержащий список не менее чем из 10 блюд.
    //todo Должно быть не менее 10 блюд.
    //todo Список должен быть не пуст
    //todo Это намеки на создание тестов. Сначала тесты, потом реализация!

    public Menu(){
        list=list();
    }
    public Menu(List<Meal> l){
        List<Meal> l1 = new ArrayList<>();
        if (l.size() >=10) {
            for (int i = 0; i < l.size();i++){
                if (!l1.contains(l.get(i))){
                    l1.add(l.get(i));
                } else throw new IllegalArgumentException();
            }
            list=l1;
        } else throw new NullPointerException();
    }
    /**
     * Возвращает список блюд в меню.
     * Должен быть неизменяемым. @see Collections.unmodifiableList
     * Должен возвращать одну и ту же коллекцию объектов при кажом вызове.
     * @return список блюд в меню
     */
    public List<Meal> list(){
        List<Meal> l = new ArrayList<>();
        l.add(new Meal("паста Болоньезе",340.0f));
        l.add(new Meal("паста Песто",350.0f));
        l.add(new Meal("паста Тунец",390.0f));
        l.add(new Meal("салат Греческий",230.0f));
        l.add(new Meal("тирамиссу",320.0f));
        l.add(new Meal("чизкейк",280.0f));
        l.add(new Meal("пицца Маргарита",270.0f));
        l.add(new Meal("пицца с беконом",250.0f));
        l.add(new Meal("пицца Прага",200.0f));
        l.add(new Meal("пицца Карбонара",300.0f));
        l.add(new Meal("паста2 Карбонара",309.0f));
        return Collections.unmodifiableList(l);
    }
    public static boolean lcontains(Meal meal){
        if (list.contains(meal)){
            return true;
        }
        else return false;
    }
}

