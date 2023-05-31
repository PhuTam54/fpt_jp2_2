package demo2;

public class OrderCafe extends Order<String>{
	public void prinCode() {
		System.out.println(this.getCode());
	}
}