package annotation;

public class TestAnnotation {
    /**
     * @Target：

    表示该注解可以用于什么地方，可能的ElementType参数有：
    CONSTRUCTOR：构造器的声明
    FIELD：域声明（包括enum实例）
    LOCAL_VARIABLE：局部变量声明
    METHOD：方法声明
    PACKAGE：包声明
    PARAMETER：参数声明
    TYPE：类、接口（包括注解类型）或enum声明

     @Retention

     表示需要在什么级别保存该注解信息。可选的RetentionPolicy参数包括：
     SOURCE：注解将被编译器丢弃
     CLASS：注解在class文件中可用，但会被VM丢弃
     RUNTIME：VM将在运行期间保留注解，因此可以通过反射机制读取注解的信息

     @Document

     将注解包含在Javadoc中

     @Inherited

     允许子类继承父类中的注解
     */
    @MyAnnotation(param = "dfdf")
    public static void  testAnno(){
        System.out.println("我是注解测试类");
    }

    public static void main(){
        try {
            Class cls = Class.forName("annotation.MyAnnotation");
            MyAnnotation anno = (MyAnnotation) cls.getAnnotation(MyAnnotation.class);
            System.out.println("customAnnotation mySkill:" + anno.param());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
