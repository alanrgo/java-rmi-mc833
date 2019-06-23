

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
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
        ArrayList<Profile> profiles = repository.getAllProfilesByCertification(courseName);
        Payload payload = new Payload();
        payload.message = profiles.get(0).toString();
        return payload;
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
        payload.file = repository.getFileStream(aux.filePath);
        payload.fileSize = payload.file.length;
        payload.fileName = aux.filePath;
        return payload;
    }




}
