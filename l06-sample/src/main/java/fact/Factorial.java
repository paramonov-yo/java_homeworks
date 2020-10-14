package fact;

public class Factorial {
    public int calc(int size) {
        if (size < 0 ) throw new FactorialNegativeException();
        if (size <= 1) return 1;
        long temp = (long)size * calc( size-1 );
        if ( temp > Integer.MAX_VALUE ) throw new FactorialException();
        return (int) temp;
    }
}


