import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ArmstrongNumberServer {
    public static void main(String[] args) {
        try {
            ArmstrongNumberChecker checker = new ArmstrongNumberCheckerImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ArmstrongNumberChecker", checker);
            System.out.println("ArmstrongNumberChecker is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
