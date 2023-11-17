# javapackage utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.app.core.*;
import static tester.testCustomer.map;
public interface IOUtil {
  public static void storeBin(String file) throws FileNotFoundException, IOException {
	  try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file))){
		  out.writeObject(map);
	  }
  }


  public static Map<String,Customer> readBin(String file){
	  try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(file))){
		  return (Map<String,Customer>)in.readObject();
	  }catch(Exception e) {
		  return new HashMap<>();
		  
	  }
  }
}
