package Settings;

public class StringSetting extends Setting{
    private String text;

    public StringSetting(String name, String text, Runnable method){
        super(name, method);
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String toString(){
        return super.getName() + ": " + text;
    }
}
