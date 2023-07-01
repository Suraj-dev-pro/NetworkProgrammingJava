import java.util.Scanner;

public class SpamCheckDemo {
    public static void main(String[]args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a message");
        String message = scanner.nextLine();

        if(isSpam(message)){
            System.out.println("The message is spam");
        }else{
            System.out.println("The message is not spam");

        }
    }
    private static boolean isSpam(String message){
        String[] spamwords = {"buy","gift","lucky","money","lottery","free"};

        for(String word: spamwords){
            if(message.toLowerCase().contains(word)){
                return true;
            }
        }
        return false;
    }
}
