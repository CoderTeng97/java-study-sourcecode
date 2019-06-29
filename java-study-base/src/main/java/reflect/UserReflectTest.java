package reflect;

import java.lang.reflect.Method;

public class UserReflectTest {
    public static  void main(String[] args){
        /**获取class类的三种方法*/
        /**第一种 实例化*/
//        User user1 = new User();
//        user1.setUsername("user1");

        /**第二种 直接获取class类*/

//        Class user2 = User.class;  //等同于 Class.forName(User.class)
//        Method[] methods =  user2.getMethods();
//        for(Method method : methods){
//            System.out.println("user2 method : " + method);
//        }
        /**第三种 通过加载获取*/
        Class user3 = null;
        try {
            user3 = Class.forName("reflect.User");
            Method[] methods = user3.getDeclaredMethods();
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
