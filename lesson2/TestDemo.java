
public class TestDemo {
	
	// 常量只能被初始化一次，且使用的时候一定要记得初始化
	public static void main (String[] args) {
		// 定义常量，建议名称全大写
		final int MAXNUM = 10;
		System.out.println(MAXNUM);
	}

	/**
	 * 布尔类型：
	 * 1.在JAVA中，布尔类型 没有明确的大小
	 * 2.在JAVA中，布尔类型 只有两个取值 true 和 false
	 * 3.在JAVA中，没有 所谓的 0是假 非0是真
	 */
	public static void main8 (String[] args) {
		boolean flg = true;
		System.out.println(flg);

		//报错，只能为布尔值
		/*if (1) {

		}*/

	}

	//短整型：short  2个字节 数值：-32768 ~ 32767
	public static void main7 (String[] args) {
		short sh = 12;
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
	}


	// 字节：byte 1个字节 数值：-128 ~ 127
	// 每一种数据类型，在给其赋值的时候，一定不能超过它的范围
	public static void main6 (String[] args) {
		byte b = 12;
		byte c = 21;
		System.out.println(b + " " + c);

		// byte d = Byte.MAX_VALUE + 1;此处会进行整型提升,从int->byte会编译错误
		System.out.println(Byte.MAX_VALUE + 1); //默认输出整型，整型是可以保存数值128的
	
		System.out.println(Integer.MAX_VALUE);
		//int i1 = 2147483648; //报错，超出数据类型的范围(Java只会检查 直接赋值的字面值常量是否超出)
		
		//下面的均不会编译报错
		int i2 = 2147483647 + 1;
		System.out.println(i2);
		int i3 = Integer.MAX_VALUE + 1;
		System.out.println(i3);
		System.out.println(Integer.MAX_VALUE + 1);

	}

	/**
	 *	字符数据类型：
	 * 		char 	2个字节  0 ~ 65535
	 * Unicode --> 包含很多字符集，如中文，拉丁文等等
	 */
	public static void main5 (String[] args) {
		char ch = 'a';
		System.out.println(ch);

		char ch2 = '高';
		System.out.println(ch2);

		char ch3 = 97;
		System.out.println(ch3); 
	}

	/**
	 * 单精度 float
	 * 1.  double  8个字节
	 * 2.  float   4个字节
	 */
	public static void main4 (String[] args) {
		// float f = 12.3; 会出现错误，不允许从double类型转到float类型
		float f = 12.3f;
		System.out.println(f);
		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
	}


	/**
	 *	双精度 浮点型
	 * @param args [description] 
	 */
	public static void main3 (String[] args) {
		double d = 12.5;
		System.out.println(d);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
	}


	/**
	 * String[] args 代表命令行参数
	 * @param args [description] 
	 */
	public static void main2 (String[] args) {
		int i = 0;
		for (i = 0; i < args.length; ++i)
		{
			System.out.println(args[i]);
		}
		System.out.println("kaixin");
	}

	public static void main1 (String[] args) {
		long a = 10L;
		System.out.println(a);
		System.out.println("最大值：" + Long.MAX_VALUE); // + 为拼接
		System.out.println("最小值：" + Long.MIN_VALUE);

		int b = 10;
		int c = 20;
		System.out.println(b + c);
		//注意：任何类型的数据 和 字符串进行拼接，结果都是字符串
		System.out.println("hhh" + b + c);
	}

}

