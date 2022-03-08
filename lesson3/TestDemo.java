import java.util.Scanner;
public class TestDemo {
	public static void main (String[] args) {
		long a = 1L;
		switch (a) {
			case 1:
				System.out.println("1");
				break;
			case 2:
				System.out.println("2");
				break;
			default:
				System.out.println("输入正确的数字")；
				break;
		}
	}


	public static void main3 (String[] args) {
		Scanner scan = new Scanner(System.in);

		//退出循环-》 1.ctrl+c 	2.ctrl+d
		while (scan.hasNextInt()) {
			int year = scan.nextInt();
			if ((year%4==0 && year%100!=0) || (year%400==0)) {
				System.out.println("闰年！");
			} else {
				System.out.println("不是闰年");
			}
		}
	}


	public static void main2 (String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		System.out.println(a);

		String str = scan.next();
		System.out.println(str);
	}


	public static void main1 (String[] args) {
		int i = 10;
		i = i++;

		//输出10，这个跟C语言不同
		System.out.println(i);
	}
}