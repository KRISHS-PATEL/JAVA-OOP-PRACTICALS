import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {}

class SampleTests {
    @Run
    public void testOne() { System.out.println("Test one passed"); }

    @Run
    public void testTwo() { System.out.println("Test two passed"); }

    public void notATest() { System.out.println("Should not run"); }
}

public class MiniTestRunner {
    public static void main(String[] args) throws Exception {
        Object testObject = new SampleTests();
        int count = 0;
        for (Method method : testObject.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Run.class) && method.getParameterCount() == 0) {
                method.invoke(testObject);
                count++;
            }
        }
        System.out.println("Tests run: " + count);
    }
}
