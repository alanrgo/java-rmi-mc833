import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ResumeInterface extends Remote {

    Payload echo(String str) throws RemoteException;

    Payload listAllFromCourse(String courseName ) throws RemoteException;

    Payload listAllSkillsFromCity(String cityName) throws  RemoteException;

    Payload addExperience(String exp) throws RemoteException;

    Payload getExperienceByEmail(String email) throws RemoteException;

    Payload[] listAllProfiles() throws RemoteException;

    Payload getUserProfileByEmail(String email) throws RemoteException;
}
