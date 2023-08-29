import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ArmstrongNumberChecker extends Remote {
    boolean isArmstrong(int number) throws RemoteException;
}
