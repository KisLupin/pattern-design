package prototype;

import java.util.List;

public class PrototypePatternTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employees source = new Employees();
        source.loadData();

        //Use the clone method to get the Employee object
        Employees empsOne = (Employees) source.clone();
        Employees empsTwo = (Employees) source.clone();
        List<String> list = empsOne.getEmpList();
        list.add("John");
        List<String> list1 = empsTwo.getEmpList();
        list1.remove("Pankaj");

        System.out.println("source List: " + source.getEmpList());
        System.out.println("empsOne List: " + list);
        System.out.println("empsTwo List: " + list1);
    }
}
