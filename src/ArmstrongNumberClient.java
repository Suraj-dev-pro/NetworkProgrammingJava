import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ArmstrongNumberClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            ArmstrongNumberChecker checker = (ArmstrongNumberChecker) registry.lookup("ArmstrongNumberChecker");

            int number = 190;
            if (checker.isArmstrong(number)) {
                System.out.println(number + " is an Armstrong number.");
            } else {
                System.out.println(number + " is not an Armstrong number.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
