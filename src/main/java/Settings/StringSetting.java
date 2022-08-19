package Settings;

public class StringSetting extends Setting{
    private String text;

    public StringSetting(String name, String text){
        super(name);
        this.text = text;
    }

    public String toString(){
        return super.getName() + ": " + text;
    }
}
