

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ResumeService extends UnicastRemoteObject implements ResumeInterface {
    public ResumeService() throws RemoteException {
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
    public Payload listAllProfiles() throws RemoteException {
        return null;
    }

    @Override
    public Payload getUserProfileByEmail(String email) throws RemoteException {
        return null;
    }


}
