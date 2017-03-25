/**
 *
 * Блюдо из меню
 */
public class Meal {

    String name;
    Float cost;
    public Meal(String name, Float cost) {
        this.name = name;
        this.cost = cost;
    }


//todo Добавьте необходимые конструктуры и/или методы, чтобы можно было создать блюдо с указанием его наименования
//todo Подумайте, что лучше подходит. Считается, что у блюда название не изменяется ;)

    /**
     *
     * @return наименование блюда
     */
    public String getTitle(){
        return this.name;
    }

    /**
     * Вовзвращает цену с плавающей точкой.
     * @return Цена, число с плавающей точкой в у.е.
     */

    public Float getPrice(){
        return this.cost;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Meal){
            Meal m =(Meal) obj;
            return m.getTitle().equals(this.getTitle());
        }
        else return false;
    }
}