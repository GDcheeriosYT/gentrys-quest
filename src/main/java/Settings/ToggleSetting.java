package Settings;

public class ToggleSetting extends Setting{
    private Boolean toggled;

    public ToggleSetting(String name, Boolean toggled, Runnable method){
        super(name, method);
        this.toggled = toggled;
    }

    public Boolean getToggled() {
        return toggled;
    }

    public void toggleSetting(){
        toggled = !toggled;
    }

    public void setToggle(Boolean toggle) {
        this.toggled = toggle;
    }

    public String toString(){
        return super.getName() + "[" + toggled + "]";
    }
}
