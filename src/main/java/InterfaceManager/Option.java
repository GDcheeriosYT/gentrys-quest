package InterfaceManager;

public class Option {
    private String optionName;
    private Runnable method;

    public Option(String name, Runnable method) {
        optionName = name;
        this.method = method;
    }

    public String getOptionName() {
        return optionName;
    }

    public void runMethod(){
        method.run();
    }
}