import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

class FileDownloadInterfaceImplementation extends UnicastRemoteObject implements FileDownloadInterface {

	private byte [] bufferedContent;	

 	public FileDownloadInterfaceImplementation () throws Exception {
		super();
		bufferedContent = new byte [4096];
	}	


	public byte [] downloadFile(String name_of_file) throws Exception {
		System.out.println("Client making request");
		File createdFile = new File(name_of_file);
		if (validateFile(createdFile)) {
			FileInputStream fileinputstream = new FileInputStream(createdFile);
			BufferedInputStream bufferedInput = new BufferedInputStream(fileinputstream);
			DataInputStream datainput = new DataInputStream(bufferedInput);
			datainput.read(bufferedContent);
			fileinputstream.close();
			bufferedInput.close();
			datainput.close();
			return bufferedContent;
		} else {
			String message = "Something went wrong";
			byte [] messageByte = message.getBytes();
			return messageByte;
		}	
	}

	private boolean validateFile(File filename) throws Exception{
		FileInputStream fileinput = new FileInputStream(filename);
		return (fileinput.available() != 0) ? true : false;
	}
}