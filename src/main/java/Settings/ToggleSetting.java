package Settings;

public class ToggleSetting extends Setting{
    private Boolean toggled;

    public ToggleSetting(String name, Boolean toggled){
        super(name);
        this.toggled = toggled;
    }

    public Boolean getToggled() {
        return toggled;
    }

    public void toggleSetting(){
        toggled = !toggled;
    }

    public String toString(){
        return super.getName() + "[" + toggled + "]";
    }
}
