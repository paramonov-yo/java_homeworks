public class Square extends Shapes {

    //Квадрат:
    int a, squareP, squareS;

    @Override
    public int calcPerimetr(int a) {
        this.a = a;
        //Расчет периметра(P) квадрата:
        squareP = a * 4;
        System.out.println("Периметр квадрата по введенным данным равен: " + squareP);
        return squareP;
    }

    @Override
    public int calcArea(int a) {
        this.a = a;
        //Расчет площади (S) квадрата:
        squareS = a * a;
        System.out.println("Площадь квадрата по введенным данным равна: " + squareS);
        return squareS;
    }
}
