public class MapDecorator extends SmartArrayDecorator {
    private MyFunction func;

    public MapDecorator(SmartArray sa, MyFunction func) {
        super(sa);
        this.func = func;
    }

    private Object[] mapArray(Object[] objs){
        for(int i = 0; i < objs.length; i++){
            objs[i] = func.apply(objs[i]);
        }
        return objs;
    }

    @Override
    public Object[] myArr() {
        return mapArray(super.smartArray.myArr().clone());
    }

    @Override
    public String descr() {
        return "map dec";
    }

    @Override
    public int size() {
        return super.smartArray.size();
    }
}
