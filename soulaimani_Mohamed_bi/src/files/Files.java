package files;

import java.io.File;
import java.io.IOException;

public class Files {
	public static int check_file(File myObj) {
	    try {
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	        return 1;
	      } else {
	        System.out.println("File already exists.");
	        return 0;
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    return -1;
	  }
}
