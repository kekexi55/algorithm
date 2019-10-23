/***
 *
 * @author zhengchunguang
 * @date 2019-10-22 19:31
 */
public class C {
    private A a;

    public C(A a) {
        this.a = a;
    }

    public static void main(String[] args) {
        C c = new C(new B());
        A a = new B();
        System.out.println(c.a);
    }
}
