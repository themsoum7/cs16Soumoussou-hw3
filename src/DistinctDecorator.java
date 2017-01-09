public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }
    @Override
    public Object[] myArr() {
        return delEq(super.smartArray.myArr().clone());
    }
    @Override
    public String descr() {
        return "distinct dec";
    }
    @Override
    public int size() {
        return super.smartArray.size();
    }

    private Object[] delEq(Object[] objects){
        int counter = 0;
        for(int i = 0; i < objects.length; i++){
            for(int k = i+1; k < objects.length; k++){
                if(objects[i] == null){
                    break;
                }
                if(objects[i].equals(objects[k])){
                    objects[k] = null;
                    counter++;
                }
            }
        }
        Object [] res = new Object[objects.length - counter];
        int x = 0;
        for (int i = 0 ; i < objects.length; i++ ){
            if(objects[i] != null){
                res[x] = objects[i];
                x++;
            }
        }
        return res;
    }

}
