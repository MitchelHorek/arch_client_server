package pract2;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {

    public static final String UNIQUE_BINDING_NAME = "server.calculator";//уникальное имя чтобы не путаться для сервера

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {

        final RemoteCalculationServer server = new RemoteCalculationServer();

        final Registry registry = LocateRegistry.createRegistry(2732);//возможность удаленного доступа

        Remote stub = UnicastRemoteObject.exportObject(server, 0);//вытаскиваем из удаленного объекта данные и привязываем его к серверу
        registry.bind(UNIQUE_BINDING_NAME, stub);//привязка заглушки

        Thread.sleep(Integer.MAX_VALUE);

    }
}
