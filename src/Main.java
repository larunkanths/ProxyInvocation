import com.example.Client;
import com.example.proxy.ProxyFactory;

public class Main {

	public static void main(String args[]) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		Client stub = ProxyFactory.createProxy(Client.class);

		stub.login("Arun");

		System.out.println();

		stub.logout("Arun");
	}
}
