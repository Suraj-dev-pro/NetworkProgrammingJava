package RMI.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Product extends Remote {
    //let us define api

    String getName() throws RemoteException;
    String getDescription() throws RemoteException;
    double getPrice() throws RemoteException;
}

