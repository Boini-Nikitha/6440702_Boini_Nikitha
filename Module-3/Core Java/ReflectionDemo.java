import java.lang.reflect.*;

public class ReflectionDemo {
public static void main(String[] args) {
try {
Class<?> clazz = Class.forName("TestClass");
        // Create instance
        Object obj = clazz.getDeclaredConstructor().newInstance();

        // List all declared methods
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Declared methods:");
        for (Method method : methods) {
            System.out.print("Method: " + method.getName() + ", Parameters: ");
            Class<?>[] paramTypes = method.getParameterTypes();
            for (Class<?> param : paramTypes) {
                System.out.print(param.getSimpleName() + " ");
            }
            System.out.println();
        }

        // Invoke greet(String)
        Method greetMethod = clazz.getMethod("greet", String.class);
        greetMethod.invoke(obj, "World");

        Method addMethod = clazz.getMethod("add", int.class, int.class);
        Object result = addMethod.invoke(obj, 5, 3);
        System.out.println("Result of add: " + result);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}