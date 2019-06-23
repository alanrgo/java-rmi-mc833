import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repository {

    private List<Profile> profiles;
    private final String jsonFileName = "data.json";

    public Repository() {

        profiles = loadProfiles();
        System.out.println(profiles.get(0).address);

    }

    private String readJsonFile(){
        URL url = getClass().getResource(jsonFileName);
        String path = url.getPath();
        BufferedReader reader;
        String jsonContent = new String();
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while(line != null ) {
                jsonContent = jsonContent + line + "\n";
                line = reader.readLine();
            }
            return jsonContent;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private ArrayList<Profile> loadProfiles() {
        ArrayList<Profile> profiles = new ArrayList<>();
        String jsonContent = readJsonFile();
        JsonElement jelement = new JsonParser().parse(jsonContent);
        JsonObject jobject = jelement.getAsJsonObject();
        JsonArray jarray = jobject.getAsJsonArray("profiles");
        for( int i = 0; i < jarray.size(); i++ ){
            System.out.println(i);
            JsonObject jsonProfile = jarray.get(i).getAsJsonObject();
            String address = jsonProfile.get("city").getAsString();
            String course = jsonProfile.get("certification").getAsString();
            String name = jsonProfile.get("name").getAsString();
            String surname = jsonProfile.get("lastName").getAsString();
            String email = jsonProfile.get("email").getAsString();
            String fileName = jsonProfile.get("image").getAsString();

            JsonArray experienceList = jsonProfile.getAsJsonArray("experience");
            String[] experiences = new String[6];
            System.out.println(experienceList);
            for( int y = 0; y < experienceList.size(); y++ ) {
                experiences[y] = experienceList.get(y).getAsString();
            }

            JsonArray skillList = jsonProfile.getAsJsonArray("skills");
            String[] skills = new String[6];
            for( int y = 0; y < skillList.size(); y++ ) {
                skills[y] = skillList.get(y).getAsString();
            }

            Profile aux = Profile.builder()
                    .address(address)
                    .course(course)
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .filePath(fileName)
                    .experiences(experiences)
                    .skills(skills)
                    .build();
            profiles.add(aux);
        }
        return profiles;
    }


    public List<Profile> getAllProfiles() {
        return profiles;
    }

    public Profile getProfileByEmail(String email) {
        Profile aux;
        Iterator<Profile> iterator = profiles.iterator();
        while(iterator.hasNext()){
            aux = iterator.next();
            if( aux.email.equals(email) ) {
                return aux;
            }
        }
        return null;
    }

    public byte[] getFileStream(String fileName) {
        try {
            URL url = getClass().getResource(fileName);
            String pathname = url.getPath();
            System.out.println(pathname);
            File f = new File(pathname);
            FileInputStream in = new FileInputStream(f);
            byte[] fileStream = new byte[(int)f.length()]; /* This is a repository thing */
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

    public ArrayList<Profile> getAllProfilesByCertification(String courseName) {
        ArrayList<Profile> filtered = new ArrayList<>();

        for( int i = 0; i < profiles.size(); i++) {
            if (profiles.get(i).course.equals(courseName)) {
                filtered.add(profiles.get(i));
            }
        }
        if ( filtered.size() == 0 ) return null;
        return filtered;
    }
}
