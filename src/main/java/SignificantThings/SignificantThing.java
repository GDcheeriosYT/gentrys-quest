package SignificantThings;

public class SignificantThing {
    private int starRating = 0;
    private String name = "name";
    private String description = "description";
    private int level = 1;
    private long xp = 0;
    private long xpRequired = 100;
    private long previousXpRequired;

    public SignificantThing(int starRating, String name, String description, int level, long xp, long xpRequired){
        this.starRating = starRating;
        this.name = name;
        this.description = description;
        this.level = level;
        this.xp = xp;
        this.xpRequired = xpRequired;
    }

    public SignificantThing(int starRating, String name, String description){
        this.starRating = starRating;
        this.name = name;
        this.description = description;
    }

    public SignificantThing(int starRating, String name){
        this.starRating = starRating;
        this.name = name;
    }

    public SignificantThing(String name, String description){
        this.name = name;
        this.description = description;
    }

    public SignificantThing(String name){
        this.name = name;
    }

    public SignificantThing(){

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public int getStarRating() {
        return starRating;
    }

    public void addXp(int amount){
        amount += xp;
        xp = 0;
        while(amount >= xpRequired){
            levelUp(1);
            amount -= previousXpRequired;
        }
        xp = amount;
    }

    public void levelUp(int amount){
        level += amount;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }

    public long getXp() {
        return xp;
    }

    public void setXpRequired(long xpRequired) {
        this.xpRequired = xpRequired;
    }

    public long getXpRequired() {
        return xpRequired;
    }

    public void setPreviousXpRequired(long previousXpRequired) {
        this.previousXpRequired = previousXpRequired;
    }

    public long getPreviousXpRequired() {
        return previousXpRequired;
    }
}
