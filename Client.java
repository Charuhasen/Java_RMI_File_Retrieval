import java.rmi.*;
import java.rmi.registry.*;
import java.io.*;
import java.util.*;  

public class Client {
	static FileDownloadInterface filedownload= null;
 	public static void main(String [] args) throws Exception {
		Registry registry = LocateRegistry.getRegistry(8000);
		FileDownloadInterface filedownload  = (FileDownloadInterface) registry.lookup("filedownloadbind");
        
        Scanner sc =new Scanner(System.in);  
        
        System.out.println("Please Select a File: ");
        System.out.println(" [1]Antoine.txt \n [2]Charu.txt \n [3]Rooney.txt \n [4]Shada.txt \n [5]William.txt");

        try{
            int fileName = sc.nextInt();

            if (fileName == 1){
                byte [] filebyte = filedownload.downloadFile("SERVER_FILES/" + "Antoine" + ".txt");
                saveByteStream(filebyte, "CLIENT_FILES/" + "Antoine.txt");
                System.out.println("File Sent");
            }else if(fileName == 2){
                byte [] filebyte = filedownload.downloadFile("SERVER_FILES/" + "Charu" + ".txt");
                saveByteStream(filebyte, "CLIENT_FILES/" + "Charu.txt");
                System.out.println("File Sent");
            }else if(fileName == 3){
                byte [] filebyte = filedownload.downloadFile("SERVER_FILES/" + "Rooney" + ".txt");
                saveByteStream(filebyte, "CLIENT_FILES/" + "Rooney.txt");
                System.out.println("File Sent");
            }else if(fileName == 4){
                byte [] filebyte = filedownload.downloadFile("SERVER_FILES/" + "Shada" + ".txt");
                saveByteStream(filebyte, "CLIENT_FILES/" + "Shada.txt");
                System.out.println("File Sent");
            }else if(fileName == 5){
                byte [] filebyte = filedownload.downloadFile("SERVER_FILES/" + "William" + ".txt");
                saveByteStream(filebyte, "CLIENT_FILES/" + "William.txt");
                System.out.println("File Sent");
            }else{
                System.out.println("Please enter either 1,2,3,4 or 5 ");
            }
        }catch(InputMismatchException  e){
                System.out.println("Please enter either 1,2,3,4 or 5 ");
        }
	}

	public static void saveByteStream(byte [] savestream, String fileDestination) throws Exception {
		File saveStreamFile = new File(fileDestination);
		if (saveStreamFile != null) {
			FileOutputStream fileoutput = new FileOutputStream(saveStreamFile);
			fileoutput.write(savestream);
			fileoutput.flush(); 
			fileoutput.close();
		} else {
		    System.out.println("Something went wrong opening " + fileDestination);
		}
	}
}