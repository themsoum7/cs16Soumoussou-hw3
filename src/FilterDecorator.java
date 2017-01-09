public class FilterDecorator extends SmartArrayDecorator{
    private MyPredicate pr;

    public FilterDecorator(SmartArray sa, MyPredicate pr) {
        super(sa);
        this.pr = pr;
    }

    private Object[] filterArray(Object[] objs) {

        int counter = 0;
        for (int i = 0; i < objs.length; i++) {
            if (!pr.test(objs[i])) {
                objs[i] = null;
                counter++;
            }
        }
        Object[] res = new Object[objs.length - counter];
        int x = 0;
        for (int i = 0; i < objs.length; i++) {
            if (objs[i] != null) {
                res[x] = objs[i];
                x++;
            }
        }
        return res;
    }

    @Override
    public Object[] myArr() {
        return filterArray(super.smartArray.myArr().clone());
    }

    @Override
    public String descr() {
        return "filter dec";
    }

    @Override
    public int size() {
        return super.smartArray.size();
    }
}
