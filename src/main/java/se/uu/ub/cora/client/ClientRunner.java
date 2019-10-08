package se.uu.ub.cora.client;

public class ClientRunner {

	public static void main(String[] args) {
		AppTokenClientFactoryImp appTokenClientFactory = new AppTokenClientFactoryImp(
				"https://cora.epc.ub.uu.se/diva/apptokenverifier/");

		RestClientFactoryImp restClientFactory = new RestClientFactoryImp(
				"https://cora.epc.ub.uu.se/diva/rest/");

		CoraClientImp coraClientImp = new CoraClientImp(appTokenClientFactory, restClientFactory,
				// "141414", "63e6bd34-02a1-4c82-8001-158c104cae0e");
				"coraUser:4412982402853626", "b27039e1-593d-4d95-a69a-b33aa8c0924a");
		String read = coraClientImp.read("coraText", "nameAuthorizedGroupText");
		System.out.println(read);

	}

	// AppTokenClientFactoryImp appTokenClientFactory = new AppTokenClientFactoryImp(
	// "http://localhost:8080/apptokenverifier/");
	// RestClientFactoryImp restClientFactory = new RestClientFactoryImp(
	// "http://localhost:8080/therest/rest/");
}
