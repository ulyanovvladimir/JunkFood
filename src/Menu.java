import java.util.*;

/**
 *
 * Меню. Список блюд
 *
 */
public class Menu {
    static private List<Meal> menu;

    public Menu() {
        menu = new ArrayList();
        menu.add(new Meal("Meal0", 10.5F));
        menu.add(new Meal("Meal1", 11F));
        menu.add(new Meal("Meal2", 12.5F));
        menu.add(new Meal("Meal3", 13F));
        menu.add(new Meal("Meal4", 14F));
        menu.add(new Meal("Meal5", 15.5F));
        menu.add(new Meal("Meal6", 16.5F));
        menu.add(new Meal("Meal7", 17F));
        menu.add(new Meal("Meal8", 18.5F));
        menu.add(new Meal("Meal9", 19.5F));
    }

    public List<Meal> list(){
        return Collections.unmodifiableList(menu);
    }

    public static boolean contains(Meal m) {
        return menu.contains(m);
    }
}
