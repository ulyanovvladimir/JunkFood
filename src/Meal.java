/**
 *
 * Блюдо из меню
 */
public class Meal {

    //todo Добавьте необходимые конструктуры и/или методы, чтобы можно было создать блюдо с указанием его наименования
    //todo Подумайте, что лучше подходит. Считается, что у блюда название не изменяется ;)
    private final String title;
    private Float price;

    /**
     * @return наименование блюда
     */
    public Meal(String title, Float price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
        //        throw new UnsupportedOperationException();
    }

    /**
     * Вовзвращает цену с плавающей точкой.
     *
     * @return Цена, число с плавающей точкой в у.е.
     */

    public Float getPrice() {
        return this.price;
        //  throw new UnsupportedOperationException();
    }

    public void setPrice(Float newPrice) {
        this.price = newPrice;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Meal) {
            Meal m = (Meal) obj;
            return m.getTitle().equals(this.getTitle());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.title.hashCode();
    }

}
