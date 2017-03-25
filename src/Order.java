import java.util.ArrayList;
import java.util.List;

/**
 * Заказ
 */
public class Order {
    /**
     * Добавляет одно блюдо в заказ.
     *
     *
     * todo Сначала написать тесты!
     *
     *
     * @param meal блюдо из меню
     */

    private static List<Meal> lorder;

    public Order(){
        lorder= new ArrayList<>();
    }
    public void addMeal(Meal meal){
        // todo Блюдо должно быть из меню.
        // todo В случае, если блюдо не изменю, должно кидать IllegalArgumentException
        // todo Блюдо должно быть не null.
        if (!(meal==null) && Menu.lcontains(meal)){
            // todo добавляем блюдо в заказ
            lorder.add(meal);
        }
        else throw new IllegalArgumentException();
    }
    public void addMeal(Meal meal,int count){
        // todo Блюдо должно быть из меню.
        // todo В случае, если блюдо не изменю, должно кидать IllegalArgumentException
        // todo Блюдо должно быть не null.
        if (meal!=null && Menu.lcontains(meal)){
            // todo добавляем блюдо в заказ
            for (int i=0; i<count;i++) {
                lorder.add(meal);
            }
        }
        else throw new IllegalArgumentException();
    }

    //todo добавить возможность добавления нескольких порций  одного блюда, например, два чая.
    //todo чтобы можно было сделать, например, addMeal(teaMeal, 2)
    //todo TESTS!


    /**
     * Возвращает сумму заказа, суммирующая цены каждого блюда,
     * умноженные на количество каждого блюда в заказе.
     *
     * @return сумму заказа в у.е., число с плавающей точкой
     */
    public Float totalSum(){
        Float sum = (float) 0;
        for (Meal e : lorder){
            sum=sum+ e.getPrice();
        }
        return sum;
    }
}
