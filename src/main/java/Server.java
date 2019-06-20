import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            ResumeService service = new ResumeService();
            reg.rebind("resume", service);

            System.out.println("System is ready!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
