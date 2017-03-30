/**
 *
 * Блюдо из меню
 */
public class Meal {

    private String title;
    private float price;
    //todo Добавьте необходимые конструктуры и/или методы, чтобы можно было создать блюдо с указанием его наименования
    //todo Подумайте, что лучше подходит. Считается, что у блюда название не изменяется ;)

    /**
     *
     * @return наименование блюда
     */
    public Meal(String title, float price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle(){
        return title;
    }

    /**
     * Вовзвращает цену с плавающей точкой.
     * @return Цена, число с плавающей точкой в у.е.
     */
    public Float getPrice(){
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Meal) {
            Meal m = (Meal) obj;
            return m.getTitle().equals(this.getTitle());
        }
        else {return false;}
    }

    public int hashCode() {
        return this.title.hashCode();
    }
}
