import java.util.Arrays;
public class SmartArrayApp {

    public static Integer[]
    PositiveIntegersMultipliedBy2(Integer[] integers) {

        MyPredicate pr = t -> ((Integer) t) > 0;

        MyComparator cmp = (o1, o2) -> ((Integer) o1) - ((Integer) o2);

        MyFunction func = t -> 2 * ((Integer) t);

        SmartArray sa = new BaseArray(integers);
        sa = new MapDecorator(new SortDecorator(new FilterDecorator(sa, pr), cmp), func);
        Object[] res = sa.myArr();
        return Arrays.copyOf(res, res.length, Integer[].class);
    }

    public static String[]
    DistinctStudentByNameOn3rdYear(Student[] students) {
        MyPredicate prYear = t -> ((Student) t).getYear() == 3;

        MyPredicate prGPA = t -> ((Student) t).getGPA() >= 3;

        MyComparator byName = (o1, o2) -> (((Student) o1).getName().compareTo(((Student) o2).getName()));
        MyFunction myFunc = t -> ((Student) t).getName() + " " + ((Student) t).getName();

        SmartArray smArray = new BaseArray(students);
        smArray = new FilterDecorator(smArray, prYear);
        smArray = new FilterDecorator(smArray, prGPA);
        smArray = new DistinctDecorator(smArray);
        smArray = new SortDecorator(smArray, byName);
        smArray = new MapDecorator(smArray, myFunc);
        Object[] res = smArray.myArr();
        return Arrays.copyOf(res, res.length, String[].class);
    }
}