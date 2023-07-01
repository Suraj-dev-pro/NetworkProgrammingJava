package RMI.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
            //set hostname for the server using javaProperty
            System.setProperty("java.rmi.server.hostname","127.0.0.1");

            //lets create product object
            ProductImpl p1 = new ProductImpl("Laptop", "lenovo laptop", 111240.5);
            ProductImpl p2 = new ProductImpl("Mobile", "Apple", 12240.5);
            ProductImpl p3 = new ProductImpl("PC", "Dell", 12401.5);
            ProductImpl p4 = new ProductImpl("Bike", "Yamaha", 444240.5);

            //export pq,p2,p3 and p4 object using UnicastRemoteObject Class
            Product stub1 = (Product) UnicastRemoteObject.exportObject(p1,0);
            Product stub2 = (Product) UnicastRemoteObject.exportObject(p2,0);
            Product stub3 = (Product) UnicastRemoteObject.exportObject(p3,0);
            Product stub4 = (Product) UnicastRemoteObject.exportObject(p4,0);

            //Register the exported class in RMI registry with some name,
            //Client will use that name to get the reference of those exported object

            //Get the registry to register the object
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",8080);

            registry.bind("L",stub1);
            registry.bind("M",stub2);
            registry.bind("P",stub3);
            registry.bind("B",stub4);



        } catch (Exception e) {
            System.out.println("Some server error.." + e);
        }
    }
}