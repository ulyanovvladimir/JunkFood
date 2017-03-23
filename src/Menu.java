import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Меню. Список блюд
 *
 */
public class Menu {
    private List<Meal> menuList;

    public void create(){
        Meal meal1 = new Meal();
        meal1.create("chicken1",100.16);
        this.add(meal1);

        Meal meal2 = new Meal();
        meal2.create("chicken2",100.16);
        this.add(meal2);

        Meal meal3 = new Meal();
        meal3.create("chicken3",100.16);
        this.add(meal3);

        Meal meal4 = new Meal();
        meal4.create("chicken4",100.16);
        this.add(meal4);

        Meal meal5 = new Meal();
        meal5.create("chicken5",100.16);
        this.add(meal5);

        Meal meal6 = new Meal();
        meal6.create("chicken6",100.16);
        this.add(meal6);

        Meal meal7 = new Meal();
        meal7.create("chicken7",100.16);
        this.add(meal7);

        Meal meal8 = new Meal();
        meal8.create("chicken8",100.16);
        this.add(meal8);

        Meal meal9 = new Meal();
        meal9.create("chicken9",100.16);
        this.add(meal9);

        Meal meal10 = new Meal();
        meal10.create("chicken10",100.16);
        this.add(meal10);

    }

    private void add(Meal meal)  {
        if (this.menuList != null) {
            int l = this.menuList.size();
            for (int i = 0; i < l; i++) {
                Meal mealll =this.menuList.get(0);
                if (this.menuList.get(i).equals(meal)) {
                    throw new IllegalArgumentException();

                }
            }
            this.menuList.add(l,meal);
        }else{
            this.menuList = new ArrayList<>();
            int l = 0;
            this.menuList.add(meal);
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
        return this.menuList;
    }
}
