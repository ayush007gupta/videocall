package webcamtutorial;

import java.io.IOException;
import java.net.*;

public class server {
   
    public static void main(String[] args) throws IOException {
      ServerSocket s=new ServerSocket(6666);
      Socket so=s.accept();
      
    }
   
}
