import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import com.saxonica.xqj.SaxonXQDataSource;

public class Ass7 {
   public static void main(String[] args){
      try {
         execute();
      }
      
      catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      
      catch (XQException e) {
         e.printStackTrace();
      }
   }

   private static void execute() throws FileNotFoundException, XQException{
      InputStream inputStream = new FileInputStream(new File("/home/adi/Desktop/Eclipse Projects/Exp7/src/books.xqy"));
      XQDataSource ds = new SaxonXQDataSource();
      XQConnection conn = ds.getConnection();
      XQPreparedExpression exp = conn.prepareExpression(inputStream);
      XQResultSequence result = exp.executeQuery();
      while (result.next()) {
          System.out.println(result.getItemAsString(null));
       }
      
      InputStream iStream = new FileInputStream(new File("/home/adi/Desktop/Eclipse Projects/Exp7/src/books2.xqy"));
      XQDataSource ds1 = new SaxonXQDataSource();
      XQConnection conn1 = ds1.getConnection();
      XQPreparedExpression exp1 = conn1.prepareExpression(iStream);
      XQResultSequence result1 = exp1.executeQuery();
      System.out.println("\n\n");
      while (result1.next()) {
    	  
         System.out.println(result1.getItemAsString(null));
      }
   }	
}
