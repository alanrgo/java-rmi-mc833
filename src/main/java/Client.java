import java.io.File;
import java.io.FileOutputStream;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            ResumeInterface rInterface = (ResumeInterface) reg.lookup("resume");
//            Payload message =  rInterface.getUserProfileByEmail("alan@ricardo.com");
//            System.out.println("Echo: " + message.message);
//            System.out.println("File size: " + message.fileSize);
//            String clientFileName = "client_" + message.fileName ;
//            System.out.println("File Name: " + clientFileName);
//            File f = new File(clientFileName);
//            f.createNewFile();
//            FileOutputStream out = new FileOutputStream(f, true);
//            out.write(message.file, 0, message.fileSize);
//            out.flush();
//            out.close();
            Payload message = rInterface.listAllFromCourse("Computer Science");
            System.out.println(message.message);
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
