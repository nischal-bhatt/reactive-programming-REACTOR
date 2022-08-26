import java.util.function.Supplier;

public class MainClass {

	public static void main(String[] args) {

		testEarlyEvaluation();
		System.out.println("------------------");
		testLazyEvaluation();

	}

	static void testLazyEvaluation() {
		Supplier<Boolean> b1 = () -> compute("BB");
		Supplier<Boolean> b2 = () -> compute("AA");
		System.out.println(match(b1, b2));

	}

	static void testEarlyEvaluation() {
		boolean b1 = compute("BB");
		boolean b2 = compute("AA");
		System.out.println(match(b1, b2));
	}

	static String match(Supplier<Boolean> a, Supplier<Boolean> b) {
		return a.get() && b.get() ? "Match" : "NON MATCH";
	}

	static String match(boolean b1, boolean b2) {
		return b1 && b2 ? "Match" : "NON MATCH";
	}

	static boolean compute(String str) {
		System.out.println("Thread sleeping, imagine if this was heavy computation...");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("compute is invoked..");
		return str.contains("A");
	}

}
