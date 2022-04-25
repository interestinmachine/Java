package StringBuffer_;

public class StringBuffer01 {
    public static void main(String[] args) {
        //1. StringBuffer 的直接父类是 AbstractStringBuilder
        //2. StringBuffer 实现了 Serializable,即 StringBuffer的对象可以串行化
        //3. 在父类中 AbstractStringBuilder 有属性 char[] value，不是 final
        //   该value 数组存放字符串内容，引出存放在堆中的
        //4. StringBuffer 是一个 final 类，不能被继承
        //5. 因为StringBuffer字符内容是存放在 char[] value，所以在变化（增加/删除）
        //   不用每次都要更换地址（即不是每次创建新对象），所以效率要高于 String
        StringBuffer stringBuffer = new StringBuffer("hello");
    }
}

