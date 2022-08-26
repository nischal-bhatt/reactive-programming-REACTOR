import java.util.function.Supplier;

public class SupplierSupplier {

	public SupplierSupplier()
	{
		System.out.println("inside constructor");
		this.getSupplier();
		//here we are not calling get on the supplier,
		//so the getSomething method is NOT executed yet!
	}
	
	public Supplier<String> getSupplier()
	{
		System.out.println("inside getSupplier");
		return () -> getSomething();
	}
	
	private String getSomething()
	{
		System.out.println("inside get something method");
		return "nish b nish";
	}
}
