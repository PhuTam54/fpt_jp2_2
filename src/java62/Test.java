package java62;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<String> stackChuoi = new Stack<String>();
		
//		stackChuoi.push("gia tri") ==> đưa giá trij vào stack
//		stackChuoi.pop() ==> lấy giá trị ra 
//		stackChuoi.peek() ==> lấy giá trị ra nhưng không xóa khỏi stack
//		stackChuoi.clear(); ==> xóa tất cả phần tử trong stack 
//		stackChuoi.contains("gia tri") ==> xác định giá trị có tồn tại trong stack hay không 
		
		// ví dụ đảo ngược chuỗi
		System.out.println("Nhập vào chuỗi: ");
		String s = sc.nextLine();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			stackChuoi.push(s.charAt(i) + "");
		}
		System.out.println("Chuỗi đảo ngược: ");
		for (int i = 0; i < len; i++) {
			System.out.print(stackChuoi.pop());
		}
		
		// ví dụ chuyển từ hệ thập phân sang hệ nhị phân
		Stack<String> stachSoDu = new Stack<String>();
		System.out.println("\nNhập 1 số nguyên dương");
		int x = sc.nextInt();
		while (x > 0) {
			int soDu = x % 2;
			System.out.print(soDu);
			stachSoDu.push(soDu + "");
			x /= 2;
		}
		System.out.println("\nSố nhị phân là");
		int n = stachSoDu.size();
		for (int i = 0; i < n; i++) {
			System.out.print(stachSoDu.pop());
		}
	} 	
}
