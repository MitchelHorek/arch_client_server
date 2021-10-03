package pract2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Calculator extends Remote {
    ArrayList<Double> multiply(double a, double b, double c) throws RemoteException;
}