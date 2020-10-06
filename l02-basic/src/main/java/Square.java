public class Square extends Shapes {
    double a, squareP, squareS;

    Square (double a) {
        this.a = a;
    }
//Квадрат:

    public double calcPerimetr() {
        //Расчет периметра(P) квадрата:
        squareP = a * 4;
        System.out.println("Периметр квадрата по введенным данным равен: " + squareP);
        return squareP;
    }

    public double calcArea() {
        //Расчет площади (S) квадрата:
        squareS = a * a;
        System.out.println("Площадь квадрата по введенным данным равна: " + squareS);
        return squareS;
    }
}
