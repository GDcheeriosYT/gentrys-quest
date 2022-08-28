package InterfaceManager;

public class Option {
    private String optionName;
    private Interface  linkedInterface;

    public Option(String name, Interface linkedInterface) {
        optionName = name;
        this.linkedInterface = linkedInterface;
    }

    public String getOptionName() {
        return optionName;
    }
}