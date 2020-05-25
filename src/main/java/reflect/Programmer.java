package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Programmer {
    private String name;
    public int age;
    private String address;

    public Programmer() {
    }

    private Programmer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Programmer(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void test() {
        System.out.println("test---无参无返回值方法");
    }

    public void test2(String str) {
        System.out.println("test2---带参无返回值方法");
    }

    public String test3(String str, int num) {
        System.out.println("test3--带参带返回值方法");
        return str + "--" + num;
    }

    private void test4() {
        System.out.println("test4---私有方法");
    }
    
	@Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Programmer programmer = new Programmer();
        Class class1 = programmer.getClass();
        Class class2 = Programmer.class;
        Class class3 = Class.forName("reflect.Programmer");
        System.out.println(class1.equals(class2));
        System.out.println(class3.equals(class2));
        System.out.println(class1.equals(class3));
        //获取无参构造器
        Constructor constructor = class1.getConstructor();
        Object object = constructor.newInstance();
        System.out.println(object);

    }
}