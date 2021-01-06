
package webcamtutorial;
import java.io.*;
import static java.lang.System.in;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
//import static webcamtutorial.Client.socket;

public class AudioServer {
    public static void main(String[] args) throws IOException, InterruptedException, LineUnavailableException {
       
        ServerSocket server  = new ServerSocket(6666);
        while(true)
        {
       
        Socket socket = server.accept();
        
        ObjectOutputStream oos =new  ObjectOutputStream(socket.getOutputStream());
        demo l=new demo("asasd",socket.getOutputStream());
        
        oos.writeObject(l);
        }
          /*  AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED , 44100, 16 , 2 , 4, 44100, false);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format, 44100);
            if(!AudioSystem.isLineSupported(info))
            {
                System.err.println("Line not supported");
            }
            
          try (TargetDataLine targetLine = (TargetDataLine)AudioSystem.getLine(info)) {
            targetLine.open();
            
            System.out.println("starting recording");
            targetLine.start();
            
        //-----------------code without thread------------
        
                    AudioInputStream  audioStream = new AudioInputStream(targetLine);
                    AudioInputStream as = new AudioInputStream(audioStream , format ,  4096);
                    
                    //File audiofile = new File("record.wav");
                    try {
                        // AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audiofile);
                        
                        //WaveFileWriter writer = new WaveFileWriter();
                       boolean f = true;
                        
                        while(f)
                        {
                            
                            
                            AudioSystem.write(as, AudioFileFormat.Type.WAVE, socket.getOutputStream());
                            as = new AudioInputStream(audioStream , format ,  4096);
                            
                        }
                      
                       
  
                   } catch (IOException ex) {
                       // Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Stopeed Recording.. ");
                    
        */
        
        
        
        
        
            
            
        //-------------------End------------------    
            
            //-----------------------Previous code with thread ------------------
           /* Thread thread;
            thread = new Thread()
            {
                public  void run()
                {
                    AudioInputStream  audioStream = new AudioInputStream(targetLine);
                    AudioInputStream as = new AudioInputStream(audioStream , format ,  44100);
                    
                    //File audiofile = new File("record.wav");
                    try {
                        // AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audiofile);
                        
                        //WaveFileWriter writer = new WaveFileWriter();
                       
                        
                        while(true)
                        {
                            AudioSystem.write(as, AudioFileFormat.Type.WAVE, socket.getOutputStream());
                            /*OutputStream out = socket.getOutputStream();
                            byte buffer[] = new byte[2048];
                            int count;
                            while ((count = as.read(buffer)) != -1) {
                                out.write(buffer, 0, count);
                            }*/
                            // writer.write((AudioInputStream) in, AudioFileFormat.Type.WAVE, socket.getOutputStream());
                        }
                      
                       /*OutputStream out = socket.getOutputStream();
                        
                        InputStream in = ( InputStream)audioStream;
                        for (int i = 0; i < 100000; i++) {
                            System.out.println(i);
                        }
                        byte buffer[] = new byte[2048];
                        int count;
                        while ((count = in.read(buffer)) != -1) {
                            out.write(buffer, 0, count);
                        }
                     */
                 /*  } catch (IOException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Stopeed Recording.. ");
                    
                }
            };
            thread.start();
            boolean f = true;
            
            while(f)
            {
                System.out.println();
            }
            
            
            Thread.sleep(5000);
            
            thread.join();
            targetLine.stop();
            
            for(int i=0;i<100000;i++)
            {
                System.out.println(i);
                Thread.sleep(1000);
            }
            
        }*/
            

        //System.out.println("server: shutdown");
    }
