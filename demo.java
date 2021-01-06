
package webcamtutorial;

import java.io.OutputStream;
import java.io.Serializable;


public class demo implements Serializable
{
    String s;
    public transient OutputStream d;
    public demo(String si,OutputStream k)
    {
        s=si;
        d=k;
    }
    
}
