package StringBuffer_;

public class StringBuffer03 {
    public static void main(String[] args) {

        // String --> StringBuffer
        String str = "hello tom";
        //方式1：使用构造器
        //注意：返回的是 StringBuffer 对象，对 str 本身没有影响
        StringBuffer stringBuffer = new StringBuffer(str);

        //方式2：使用 append 方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);

        // StringBuffer --> String
        StringBuffer stringBuffer2 = new StringBuffer("hello world");
        //方式1：使用 StringBuffer 提供的 toString 方法
        String s = stringBuffer2.toString();

        //方式2：使用构造器
        String s1 = new String(stringBuffer2);
    }
}

