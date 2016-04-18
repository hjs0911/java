import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;

public class FileManager {
	public void save(Data data) throws IOException {
		  String currentDate = new SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
		  ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(currentDate + ".txt"));
		  oos.writeObject(data);
		  oos.close();
		 }

		 public Data load() throws IOException, ClassNotFoundException {
		  String currentDate = new SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
		  ObjectInputStream ois = new ObjectInputStream(new FileInputStream(currentDate + ".txt"));
		  Data data = (Data) ois.readObject();
		  ois.close();
		  return data;
		 }
		 public Data load(String a) throws IOException, ClassNotFoundException {
		  ObjectInputStream ois = new ObjectInputStream(new FileInputStream(a + ".txt"));
		  Data data = (Data) ois.readObject();
		  ois.close();
		  return data;
		 }

}
