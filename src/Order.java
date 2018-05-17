
import java.util.HashMap;
import java.util.Map;

/**
 * Заказ
 */
public class Order {
    /**
     * Добавляет одно блюдо в заказ.
     *
     * todo Сначала написать тесты!
     *
     *
     * @param meal блюдо из меню
     */
    private Map<Meal, Integer> order = new HashMap<>();




    // todo Блюдо должно быть из меню.
    // todo В случае, если блюдо не изменю, должно кидать IllegalArgumentException
    // todo Блюдо должно быть не null.
    // todo добавляем блюдо в заказ


    public void addMeal(Meal meal){

        addMeal(meal, 1);
    }

    public void addMeal(Meal meal, int count){
        if (!(new Menu()).list().contains(meal)) {
            throw new IllegalArgumentException("Блюдо не из меню");
        }

        int k = order.containsKey(meal) ? order.get(meal) : 0;
        order.put(meal, count + k);

        //      throw new UnsupportedOperationException();
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
        Float sum = 0.0f;
        for(Meal meal : order.keySet()){
            sum += meal.getPrice() * order.get(meal);
        }
        return sum;
    }
//        throw new UnsupportedOperationException();

}
