package javaPractice;

public final class FinalExample {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		final int b=30;
		System.out.println("a value is "+a);
		System.out.println("b value is "+b);
		a=20;
		//b=40;  //final variable value should not change
		System.out.println("a value is "+a);
	}

}
