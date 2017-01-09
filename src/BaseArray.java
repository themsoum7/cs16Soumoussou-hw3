public class BaseArray implements SmartArray {
    private Object[] data;

    public BaseArray(Object[] integers) {
        this.data = integers;
    }

    @Override
    public Object[] myArr() {
        return data;
    }

    @Override
    public String descr() {
        return "base arr";
    }

    @Override
    public int size() {
        return data.length;
    }
}
