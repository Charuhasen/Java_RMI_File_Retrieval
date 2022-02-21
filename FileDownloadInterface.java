import java.rmi.*;
import java.io.*;

interface FileDownloadInterface extends Remote {
    public byte [] downloadFile(String name_of_file) throws Exception;
}
