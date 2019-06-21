

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ResumeService extends UnicastRemoteObject implements ResumeInterface {

    private Repository repository;

    public ResumeService() throws RemoteException {
        repository = new Repository();
    }

    @Override
    public Payload echo(String str) throws RemoteException {
        Payload payload = new Payload();
        payload.message = str;
        return payload;
    }

    @Override
    public Payload listAllFromCourse(String courseName) throws RemoteException {
        return null;
    }

    @Override
    public Payload listAllSkillsFromCity(String cityName) throws RemoteException {
        return null;
    }

    @Override
    public Payload addExperience(String exp) throws RemoteException {
        return null;
    }

    @Override
    public Payload getExperienceByEmail(String email) throws RemoteException {
        return null;
    }

    @Override
    public Payload[] listAllProfiles() throws RemoteException {
        return null;

    }

    @Override
    public Payload getUserProfileByEmail(String email) throws RemoteException {
        Profile aux = repository.getProfileByEmail(email);
        Payload payload = new Payload();
        payload.message = aux.toString();
        payload.file = getFileStream(aux.filePath);
        payload.fileSize = payload.file.length;
        payload.fileName = aux.filePath;
        return payload;
    }

    private byte[] getFileStream(String fileName) {
        try {
            URL url = getClass().getResource(fileName);
            String pathname = url.getPath();
            System.out.println(pathname);
            File f = new File(pathname);
            FileInputStream in = new FileInputStream(f);
            byte[] fileStream = new byte[(int)f.length()];
            int myLen = in.read(fileStream);
            if( myLen > 0 ) {
                return fileStream;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
