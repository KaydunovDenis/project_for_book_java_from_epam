package g13.g13_6v3;

import g13.g13_6v2.NewTableFunction;

public class SecondNewTableFunction extends NewTableFunction {

    @Override
    public double getY(double x, double a) {
        return x+10;
    }

    public static void main(String[] args) {
        new SecondNewTableFunction();
    }
}
