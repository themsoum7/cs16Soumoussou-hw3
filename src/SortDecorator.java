import java.util.Arrays;

public class SortDecorator extends SmartArrayDecorator {

    private MyComparator cmp;

    public SortDecorator(SmartArray sa, MyComparator cmp) {
        super(sa);
        this.cmp = cmp;
    }

    private Object[] sortArray(Object[] objects){
        Arrays.sort(objects, cmp);
        return objects;
    }

    @Override
    public Object[] myArr() {
        return sortArray(super.smartArray.myArr().clone());
    }

    @Override
    public String descr() {
        return "sort dec";
    }

    @Override
    public int size() {
        return super.smartArray.size();
    }
}
