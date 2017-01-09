abstract class SmartArrayDecorator implements SmartArray {
    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }
}
