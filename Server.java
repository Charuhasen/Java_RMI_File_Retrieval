import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Server {
	public static void main(String [] args) throws Exception {

		FileDownloadInterfaceImplementation filedownload = new FileDownloadInterfaceImplementation();
		//System.setProperty("java.rmi.server.hostname", "192.168.8.163");

		Registry registry = LocateRegistry.createRegistry(8000);
		registry.rebind("filedownloadbind",filedownload);

		System.out.println("SERVER IS RUNNING!");
	}
}