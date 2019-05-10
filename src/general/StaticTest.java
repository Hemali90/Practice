package general; public class StaticTest {
int a = m1();
int b = m2();
{
System.out.println("in instance block");
}
public int m2() {
System.out.println("in m2");
return 0;
}
static {
System.out.println("in static block");
}
int m1() {
System.out.println("in m1");
return 0;
}
public StaticTest() {
System.out.println("in constructor");
}
public static void main(String args[]) {
System.out.println("in main");
new StaticTest();
}
}
