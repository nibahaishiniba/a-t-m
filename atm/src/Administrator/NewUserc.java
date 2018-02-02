package Administrator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
public class NewUserc {
	private UserXx UserXx;
	private UserZz UserZz;
	public NewUserc( UserXx user, UserZz userBill) {
		this.UserXx = UserXx;
		this.UserZz = UserZz;
	}
	public void aaud() {
		File file = new File("message" + File.separator + "User.txt");
		
		String idkey = UserXx.getIdCardNumber() + UserXx.getAccount();
		Map<String, UserXx> map = new HashMap<>();
		map.put(idkey, UserXx);
		try {
			
			FileInputStream f = new FileInputStream(file);
			byte[] by = new byte[1024];
			int size = f.available();
			
			if (size == 0) {
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(map);
				oos.flush();
				oos.close();
			} else {
				
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Map<String, UserXx> map1 = new HashMap<>();
				map1 = (Map<String, UserXx>) ois.readObject();
				map1.put(idkey, UserXx);
				FileOutputStream fos1 = new FileOutputStream(file);
				ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
				oos1.writeObject(map1);
				oos1.flush();
				oos1.close();
				ois.close();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
