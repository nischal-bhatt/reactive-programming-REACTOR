import java.util.function.Consumer;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {

		SupplierSupplier s = new SupplierSupplier();
		// when SupplierSupplier is initialized,
		// it calls getSupplier
		// and getSupplier returns getSomething()
		// but getSomething is ONLY EXECUTED when get() 
		// is called on the supplier. 
		// this is correct - do everything lazily!
		// do things only when you need to!
        Thread.sleep(8000);
		String x = s.getSupplier().get();
		
		System.out.println(x);

		Consumer<String> x1 = (x2) -> {
			ConsumerConsumer xx = new ConsumerConsumer();
			xx.doSomethingWithConsumer(x2);
		};
		x1.accept("nish");
	}

}
