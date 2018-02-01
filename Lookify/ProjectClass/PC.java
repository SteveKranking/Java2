public class PC {
    String name;
    String description;

    public String elevatorPitch(String name, String description) {
        this.name = name;
        this.description = description; 

        String pitch = name + "; " + description;
        return pitch;
    }

    public PC() {
        System.out.println("m8 theres nothing here");
    }

    public PC(String name) {
        this.name = name;
        System.out.println(name);
    }

    public PC(String name, String description) {
        this.name = name;
        this.description = description; 

        String pitch = name + "; " + description;
        System.out.println(pitch);
    }

}