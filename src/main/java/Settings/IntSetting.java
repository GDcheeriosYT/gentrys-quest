package Settings;

public class IntSetting extends Setting{
    private int value;
    private int minValue;
    private int maxValue;

    public IntSetting(String name, int value, Runnable method){
        super(name);
        this.value = value;
        this.minValue = Integer.MIN_VALUE;
        this.maxValue = Integer.MAX_VALUE;
    }

    public IntSetting(String name, int defaultValue, int minValue, int maxValue, Runnable method){
        super(name);
        this.value = defaultValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public void addValue(){
        value += 1;
    }

    public void subtractValue(){
        value -= 1;
    }

    public int getValue() {
        return value;
    }

    public String toString(){
        return super.getName() + ": " + value;
    }
}