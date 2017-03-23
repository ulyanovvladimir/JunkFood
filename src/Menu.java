import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Меню. Список блюд
 *
 */
public class Menu {
    public static List<Meal> NewMenu;

    public Menu(){
        NewMenu = list();
    }

    public Menu(List<Meal> list) {
        List<Meal> tempList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            tempList.add(list.get(i));
        }
        NewMenu = tempList;
    }
    //todo Создайте свое меню. Должен быть хотя бы один конструктор, который создает объект класса Menu, содержащий список не менее чем из 10 блюд.
    //todo Должно быть не менее 10 блюд.
    //todo Список должен быть не пуст
    //todo Это намеки на создание тестов. Сначала тесты, потом реализация!

    /**
     * Возвращает список блюд в меню.
     * Должен быть неизменяемым. @see Collections.unmodifiableList
     * Должен возвращать одну и ту же коллекцию объектов при кажом вызове.
     * @return список блюд в меню
     */
    public List<Meal> list(){
        List<Meal> MealList = new ArrayList<>();
        MealList.add(new Meal("Картошка", 100F));
        MealList.add(new Meal("Салат", 150F));
        MealList.add(new Meal("Кофе", 50F));
        MealList.add(new Meal("Десерт", 200F));
        MealList.add(new Meal("Стейк", 300F));
        MealList.add(new Meal("Торт", 100F));
        MealList.add(new Meal("Сок", 30F));
        MealList.add(new Meal("Котлета", 75F));
        MealList.add(new Meal("Яблоко", 35.50F));
        MealList.add(new Meal("Пицца", 120F));
        MealList.add(new Meal("Суп", 100F));
        return Collections.unmodifiableList(MealList);
    }

    public static boolean containsMeal(Meal meal){
        return NewMenu.contains(meal);
    }

}
