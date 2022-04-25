package annotation;

import java.util.ArrayList;
import java.util.List;

public class SuppressWarnings_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //1. 当我们不希望看到这些经过的时候，可以使用 SuppressWarnings 注解来抑制经过信息
        //2. 在 {""} 中，可以写入你希望抑制（不显示）的警告信息。
        //3. 关于 SuppressWarnings 作用范围是和你放置的位置相关
        //   比如 @SuppressWarnings 放置在 main 方法，那么抑制警告的范围就是 main
        //   通常我们可以放置具体的语句、方法、类。
        //4. 看看 @SuppressWarnings 的源码
        // （1）放置的位置就是 TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
        // （2）该注解类有数组：String[] value() 设置一个数组比如 {"rawtypes","unchecked"}
        /*
        @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface SuppressWarnings {
                String[] value();
        }
         */
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        int i;
        System.out.println(list.get(1));
    }
}

