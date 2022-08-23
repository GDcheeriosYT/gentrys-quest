package Settings;

import InterfaceManager.Option;
public class Setting extends Option{

    public Setting(String name, Runnable method){
        super(name, method);
    }

    public String getName() {
        return super.getOptionName();
    }
}