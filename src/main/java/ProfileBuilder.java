public class ProfileBuilder {

    private String email;
    private String name;
    private String surname;
    private String address;
    private String course;
    private String[] skills;
    private String[] experiences;
    private String filePath;

    public ProfileBuilder email(String email) {
        this.email = email;
        return this;
    }

    public ProfileBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProfileBuilder surname(String surname){
        this.surname = surname;
        return this;
    }

    public ProfileBuilder address(String address) {
        this.address = address;
        return this;
    }

    public ProfileBuilder course(String course) {
        this.course = course;
        return this;
    }

    public ProfileBuilder skills(String[] skills) {
        this.skills = skills;
        return this;
    }

    public ProfileBuilder experiences(String[] experiences) {
        this.experiences = experiences;
        return this;
    }

    public ProfileBuilder filePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public Profile build() {
        return new Profile(email, name, surname, address, course, skills, experiences, filePath);
    }
}
