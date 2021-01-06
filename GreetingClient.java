package  webcamtutorial;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.net.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import static java.lang.Thread.sleep;

import java.sql.SQLException;
import javax.imageio.ImageIO;


import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GreetingClient
{
    static Image newimg;
     static BufferedImage bimg;
    static byte[] bytes;

   public static void main(String [] args) throws InterruptedException
   {
      String serverName = "localhost";
      int port = 6066;
      try
      {
         System.out.println("Connecting to " + serverName
                             + " on port " + port);
         Socket client = new Socket(serverName, port);

         System.out.println("Just connected to "
                      + client.getRemoteSocketAddress());

        DataInputStream in=new DataInputStream(client.getInputStream());
        System.out.println(in.readUTF());
        System.out.println(in.readUTF());

         DataOutputStream out =new DataOutputStream(client.getOutputStream());
                       

         out.writeUTF("Hello from "+ client.getLocalSocketAddress());
                      
         out.writeUTF("client: hello to server");
         
         
         //------------Webcam Image capture ----------------
         
         
         Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(320 , 240));
        //webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcam.open();
        
        
         
         //Image imag = webcam.getImage();
         
         
         
         
         //------------Webcam capture code end ---------------

         /*ImageIcon img1=new ImageIcon("D:\\JavaProject\\Calculator\\2.jpg");
         Image img = img1.getImage();
         Image newimg = img.getScaledInstance(100, 120,  java.awt.Image.SCALE_SMOOTH);
         ImageIcon newIcon = new ImageIcon(newimg);*/

         //bimg = ImageIO.read(new File("D:\\JavaProject\\Calculator\\fi.jpg"));
         
         
          WebcamPanel webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setImageSizeDisplayed(true);
        webcamPanel.setFPSDisplayed(true);
        webcamPanel.setMirrored(true);
        webcamPanel.setDisplayDebugInfo(true);
        //Image im = webcamPanel.getImage();
        
       
        
        JFrame frame= new JFrame();
        
        frame.add(webcamPanel);
        
        // ImageIO.write(webcam.getImage(), "JPG", new File("fi.jpg"));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
          
         boolean f = true;
         while(f ){
         Image imag = webcam.getImage();
         
         
         //webcam.setViewSize(WebcamResolution.VGA.getSize());
        
       
         
         
         
         
         if(imag != null){
         ImageIO.write((RenderedImage) imag,"JPG",client.getOutputStream());
         System.out.println("Image sent!!!!");
         sleep(200);
         }
         }
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}

