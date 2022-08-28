package Settings;

import InterfaceManager.Option;
public class Setting extends Option{

    public Setting(String name){
        super(name, null);
    }

    public String getName() {
        return super.getOptionName();
    }
}