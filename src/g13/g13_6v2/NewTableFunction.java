package g13.g13_6v2;

import g13.g13_6.TableFunction;

public class NewTableFunction extends TableFunction {

    @Override
    public double getY(double x, double a) {
        return 2*x;
    }

    public static void main(String[] args) {
        NewTableFunction window = new NewTableFunction();
        window.setTitle("y = 2 * x");
    }
}
