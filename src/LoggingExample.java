import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExample {
    private static final Logger logger = Logger.getLogger(LoggingExample.class.getName());

    public static void main(String[]args){
        logger.info("Starting the Program");

        try{
            int result = 10/0; //simulate an exception
        }catch(Exception e){
            logger.log(Level.SEVERE,"An error occured",e);
        }

        logger.warning(" This is a warning message");
        logger.info("Program completed.");
    }
}
