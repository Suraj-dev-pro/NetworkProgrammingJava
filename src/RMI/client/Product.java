package RMI.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Product extends Remote {
    //let us define api

    public String getName() throws RemoteException;
    public String getDescription() throws RemoteException;
    public double getPrice() throws RemoteException;
}

