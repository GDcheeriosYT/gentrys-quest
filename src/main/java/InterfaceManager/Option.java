package InterfaceManager;

public class Option {
    private String optionName;
    private Interface  linkedInterface;

    public Option(String name) {
        optionName = name;
    }

    public String getOptionName() {
        return optionName;
    }
}