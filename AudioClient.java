
package webcamtutorial;


import java.io.*;
import java.net.*;
import javax.sound.sampled.*;


public class AudioClient {
    
    private static BufferedInputStream inputStream;
    private static Socket socket;
    public static void main(String[] args) throws Exception {
        
      
       
       try {
        socket = new Socket("localhost", 6666);
          
        if (socket.isConnected()) 
        {

            ObjectInputStream l=new ObjectInputStream(socket.getInputStream());
                    Object obj=null;
            try {
                obj=l.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
                return;
            }
                   
            if(obj instanceof demo)
            {
                demo ob;
                ob = (demo)obj;
                System.out.println(ob.s);
                
                
                if(ob.d ==null)
                {
                    System.out.println("webcamtutorial.AudioClient.main()");
                }
            }
            /* inputStream = new BufferedInputStream(socket.getInputStream());
            System.out.println("afaefaef");   
          
            
            Clip clip[] = new Clip[50000];
            
            for(int i=0;i<50000;i++)
            {
                clip[i]  = AudioSystem.getClip();
                AudioInputStream ais = AudioSystem.getAudioInputStream(inputStream);
                clip[i].open(ais);
                clip[i].start();
            }
           */
        }

    } catch (Exception e) {
        System.err.println(e);
    }
    }
}
       
       
    

