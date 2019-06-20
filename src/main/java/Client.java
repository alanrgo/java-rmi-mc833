import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            ResumeInterface rInterface = (ResumeInterface) reg.lookup("resume");
            Payload message =  rInterface.getUserProfileByEmail("alan@ricardo.com");
            System.out.println("Echo: " + message.message);
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
