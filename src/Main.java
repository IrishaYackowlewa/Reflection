import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        SaltedBiscuit mish = new SaltedBiscuit();
        //allMethodsClass(mish.getClass());
        //allGetsClass(mish.getClass());
        isCheckStringFinal(mish);
    }

    private static void allMethodsClass(Class<?> clazz){
        HashSet<Method> set = new HashSet();
        if (clazz.getSuperclass()!=null) {
            Method[] methodsMishExt = clazz.getSuperclass().getDeclaredMethods();
            Method[] methodsMish = clazz.getSuperclass().getMethods();
            Collections.addAll(set, methodsMishExt);
            Collections.addAll(set, methodsMish);
        }
        Method[] methodsMish = clazz.getDeclaredMethods();
        Collections.addAll(set, methodsMish);
        for (Method method: set){
            System.out.println(method.getName());
        }
    }

    private static void allGetsClass(Class<?> clazz){
        for (Method method: clazz.getMethods()){
            if(isGetter(method)) System.out.println("getter: " + method.getName());
        }
    }

    public static boolean isGetter(Method method){
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        if (void.class.equals(method.getReturnType())){
            return false;
        }
        return true;
    }

    public static void isCheckStringFinal(Object clazz){
        Field[] fields = clazz.getClass().getDeclaredFields();
        for (Field field: fields){
            if (field.getType().equals(String.class) && Modifier.isFinal(field.getModifiers())){
                field.setAccessible(true);//это не хорошо...
                try {
                    if (!field.getName().equals(field.get(clazz))){
                        System.out.println("Значение переменной " + field.getName() + " не соответствует названию");
                    }
                } catch (IllegalAccessException e) {
                    System.out.println("Что то пошло не так");
                }
            }
        }
    }
}
