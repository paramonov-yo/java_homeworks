public class Square extends Shapes {
    double a;

    Square (double a) {
        this.a = a;
    }
//Квадрат:

    public double calcPerimetr() {
        //Расчет периметра(P) квадрата:
        System.out.println("Периметр квадрата по введенным данным равен: " + a * 4);
        return a * 4;
    }

    public double calcArea() {
        //Расчет площади (S) квадрата:
        System.out.println("Площадь квадрата по введенным данным равна: " + a * a);
        return a * a;
    }
}
