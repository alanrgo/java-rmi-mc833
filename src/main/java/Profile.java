public class Profile {

    public String email;
    public String name;
    public String surname;
    public String address;
    public String course;
    public String[] skills;
    public String[] experiences;
    public String filePath;
    private byte[] file;

    public Profile(String email, String name, String surname, String address, String course, String[] skills, String[] experiences, String filePath) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.course = course;
        this.skills = skills;
        this.experiences = experiences;
        this.filePath = filePath;
    }


    public static ProfileBuilder builder() {
        return new ProfileBuilder();
    }

    @Override
    public String toString() {
        String stringifiedSkills = "";
        for (int i = 0; i < skills.length && skills[i] != null; i ++ ) {

            stringifiedSkills = stringifiedSkills + skills[i];
            if (i < skills.length - 1 ) {
                stringifiedSkills = stringifiedSkills + ", ";
            }
        }

        String stringifiedExperience = "";
        for( int i = 0; i < experiences.length && experiences[i] != null; i ++ ) {
            int index = i + 1;
            stringifiedExperience = stringifiedExperience + "(" + index +   ") " + experiences[i] + "\n";
        }

        String response = "Email: " + email + "\n" +
                "Nome: " + name + "    Sobrenome: " + surname + "\n" +
                "Residência: " + address + "\n" +
                "Formação Acadêmica: " + course + "\n" +
                "Habilidades: " + stringifiedSkills + "\n" +
                "Experiência: " + stringifiedExperience ;
        return response;
    }
}
