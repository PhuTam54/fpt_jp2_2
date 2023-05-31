package demo2;

public class Main {
	public static void main(String[] args) {
		Order<Integer> orderI = new Order<>();
		orderI.setCode(123);
		System.out.println(orderI.getCode());
		
		Order<String> orderS = new Order<>();
		orderS.setCode("Ok con de");
		System.out.println(orderS.getCode());
		
		orderS.sayHello("Xin chao");
		orderS.sayHello(3.14);
	}
}
