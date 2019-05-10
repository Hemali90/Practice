package general;
/**
 * Java provides a mechanism, called object serialization 
 * where an object can be represented as a sequence of bytes
 *  that includes the object's data as well as information about 
 *  the object's type and the types of data stored in the object.
 * 
 *  After a serialized object has been written into a file, it can
 *  be read from the file and deserialized that is, the type information
 *  and bytes that represent the object and its data can be used to recreate 
 *  the object in memory.
 */
import java.io.*;
class Employee implements java.io.Serializable
{
   public String name;
   public String address;
   public transient int SSN;
   public int number;
   
   public void mailCheck()
   {
      System.out.println("Mailing a check to " + name + " " + address);
   }
}

class SerializeDemo
{
  public static void main(String [] args)
  {
     Employee e = new Employee();
     e.name = "Reyan Ali";
     e.address = "Phokka Kuan, Ambehta Peer";
     e.SSN = 11122333;
     e.number = 101;
     
     try
     {
        FileOutputStream fileOut =
        new FileOutputStream("/tmp/employee.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(e);
        out.close();
        fileOut.close();
        System.out.printf("Serialized data is saved in /tmp/employee.ser");
     }catch(IOException i)
     {
         i.printStackTrace();
     }
  }
}

class DeserializeDemo
{
   public static void main(String [] args)
   {
      Employee e = null;
      try
      {
         FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Employee) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return;
      }
      System.out.println("Deserialized Employee...");
      System.out.println("Name: " + e.name);
      System.out.println("Address: " + e.address);
      System.out.println("SSN: " + e.SSN);
      System.out.println("Number: " + e.number);
    }
}

public class SerializingDeserializing {

}
