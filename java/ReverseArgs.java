public class ReverseArgs {
	public static void main(String[] args) {
		for (String arg : args) {
			System.out.println(new StringBuffer(arg).reverse());
		}
	}
}