/**
 *
 * Блюдо из меню
 */
public class Meal {

    //todo Добавьте необходимые конструктуры и/или методы, чтобы можно было создать блюдо с указанием его наименования
    //todo Подумайте, что лучше подходит. Считается, что у блюда название не изменяется ;)




    public Meal(String title, Float price) {
        throw new UnsupportedOperationException();
    }


    /**
     *
     * @return наименование блюда
     *
     */
    public String getTitle(){
        //todo
        throw new UnsupportedOperationException();
    }

    /**
     * Вовзвращает цену с плавающей точкой.
     * @return Цена, число с плавающей точкой в у.е.
     */
    public Float getPrice(){
        //todo
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Meal){
            Meal m = (Meal) obj;
            return m.getTitle().equals(this.getTitle());
        } else return false;
    }
}
