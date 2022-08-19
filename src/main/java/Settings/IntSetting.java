package Settings;

public class IntSetting extends Setting{
    private int value;
    private int minValue;
    private int maxValue;

    public IntSetting(String name, int value){
        super(name);
        this.value = value;
    }

    public IntSetting(String name, int defaultValue, int minValue, int maxValue){
        super(name);
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getValue() {
        return value;
    }

    public String toString(){
        return super.getName() + ": " + value;
    }
}
