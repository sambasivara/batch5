package javaPractice;

public class StaticBlock {
	static int a;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(a);
		B1 obj=new B1();
		obj.example();
		
	}
	static {
		System.out.println("This is a static block");
		a=20;
	}
	
	static class B1{
		public void example() {
			System.out.println("This is inside inner class");
		}
	}

}
