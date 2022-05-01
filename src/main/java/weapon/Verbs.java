package weapon;

public class Verbs {
    private final String normal;
    private final String critical;

    public Verbs(String normal, String critical){
        this.normal = normal;
        this.critical = critical;
    }

    public String getNormal() {
        return normal;
    }

    public String getCritical() {
        return critical;
    }
}
