import java.util.*;

public class UpperArgs2 {
	public static void main(String[] args) {
		Arrays.stream(args).forEach( arg -> System.out.println(arg.toUpperCase()) );
	}
}