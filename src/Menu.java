import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Menu {
    public static List<Meal> NewMenu;

    public Menu(){
        NewMenu = new ArrayList<>();
        NewMenu.add(new Meal("Картофель", 150F));
        NewMenu.add(new Meal("Борщ", 100F));
        NewMenu.add(new Meal("Солянка", 150F));
        NewMenu.add(new Meal("Рыба", 200F));
        NewMenu.add(new Meal("Спагетти", 300F));
        NewMenu.add(new Meal("Пельмени", 100F));
        NewMenu.add(new Meal("Котлета", 100F));
        NewMenu.add(new Meal("Плов", 250F));
        NewMenu.add(new Meal("Чай", 20F));
        NewMenu.add(new Meal("Кофе", 50F));
        NewMenu.add(new Meal("Сок", 35F));
    }

    public List<Meal> list(){
        return Collections.unmodifiableList(NewMenu);
    }

    public static boolean containsMeal(Meal meal){
        return NewMenu.contains(meal);
    }

}