package pract2;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RemoteCalculationServer implements Calculator{
    @Override
    public ArrayList<Double> multiply(double a, double b, double c) throws RemoteException {
        ArrayList<Double>result = new ArrayList<>();
        double D = b*b - 4*a*c;
        double x1;
        double x2;
        if (D>0){
            x1 = (-b+Math.sqrt(D))/(2*a);
            x2 = (-b-Math.sqrt(D))/(2*a);
            result.add(x1);
            result.add(x2);
        }
        else if (D==0){
            result.add((-b)/(2*a));
        }
        return result;
    }
}
