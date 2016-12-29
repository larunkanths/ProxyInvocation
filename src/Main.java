import com.example.client.ClientStub;
import com.example.proxy.ProxyContainer;

public class Main {

	public static void main(String args[]) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		ClientStub stub = ProxyContainer.createProxy(ClientStub.class);

		stub.login("Arun");

		System.out.println();

		stub.logout("Arun");
	}
}
