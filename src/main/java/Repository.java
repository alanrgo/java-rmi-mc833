import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repository {

    private List<Profile> profiles;

    public Repository() {

        profiles = new ArrayList<>();
        profiles.add(createAlan());
        profiles.add(createJose());
    }

    private Profile createJose() {
        String[] skills = new String[6];
        String[] experiences = new String[6];

        skills[0] = "Socket Programming";
        skills[1] = "Pesquisador";


        experiences[0] = "Pesquisador de iniciacao cientifica em Unicamp";
        experiences[1] = "Especialista em Minix";

        // Create first profile
        return Profile.builder()
                .address("Campinas")
                .course("Ciência da Computação")
                .email("jose@nascimento.com")
                .filePath("alandelon.jpg")
                .experiences(experiences)
                .skills(skills)
                .surname("Nascimento")
                .name("José")
                .build();
    }

    private Profile createAlan() {
        String[] skills = new String[6];
        String[] experiences = new String[6];

        skills[0] = "Extender a graduação";
        skills[1] = "Não pular de paraquedas";


        experiences[0] = "Não-paraquedista na escola pé no chão";
        experiences[1] = "Persona non grata na UNICAMP por tempo de graduação";

        // Create first profile
        return Profile.builder()
                .address("Campinas")
                .course("Ciência da Computação")
                .email("alan@ricardo.com")
                .filePath("alandelon.jpg")
                .experiences(experiences)
                .skills(skills)
                .surname("Gomes")
                .name("Alan Ricardo")
                .build();

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
}
