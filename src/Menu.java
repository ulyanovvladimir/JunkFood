import java.util.ArrayList;
import java.util.List;

/**
 *
 * Меню. Список блюд
 *
 */
public class Menu {
    private List<Meal> menuList;

    public void create(){
        Meal meal1 = new Meal("chicken1",100.16);
        add(meal1);

        Meal meal2 = new Meal("chicken2",100.16);
        add(meal2);

        Meal meal3 = new Meal("chicken3",100.16);
        add(meal3);

        Meal meal4 = new Meal("chicken4",100.16);
        add(meal4);

        Meal meal5 = new Meal("chicken5",100.16);
        add(meal5);

        Meal meal6 = new Meal("chicken6",100.16);
        add(meal6);

        Meal meal7 = new Meal("chicken7",100.16);
        add(meal7);

        Meal meal8 = new Meal("chicken8",100.16);
        add(meal8);

        Meal meal9 = new Meal("chicken9",100.16);
        add(meal9);

        Meal meal10 = new Meal("chicken10",100.16);
        add(meal10);

    }

    private void add(Meal meal)  {
        if (menuList != null) {
            int l = menuList.size();
            for (int i = 0; i < l; i++) {
                if (menuList.get(i).equals(meal)) {
                    throw new IllegalArgumentException();

                }
            }
            menuList.add(l,meal);
        }else{
            menuList = new ArrayList<>();
            int l = 0;
            menuList.add(meal);
        }
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
        return menuList;
    }
}
