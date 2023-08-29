import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ArmstrongNumberCheckerImpl extends UnicastRemoteObject implements ArmstrongNumberChecker {
    public ArmstrongNumberCheckerImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean isArmstrong(int number) throws RemoteException {
        int originalNumber = number;
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, 3); // For Armstrong numbers with 3 digits
            number /= 10;
        }

        return sum == originalNumber;
    }
}
