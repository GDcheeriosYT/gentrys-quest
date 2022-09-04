package Settings;

public class ToggleSetting extends Setting{
    private Boolean toggled;

    public ToggleSetting(String name, Boolean toggled){
        super(name, SettingType.TOGGLE);
        this.toggled = toggled;
    }

    public Boolean getToggled() {
        return toggled;
    }

    @Override
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
