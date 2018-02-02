package arn;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import Administrator.UserXx;
import Administrator.UserZz;
public class Cba {
	private UserXx user;
	private UserZz userz;
	public void cba(UserXx user, UserZz userz) {
		this.user = user;
		this.userz = userz;
	}
	@SuppressWarnings("unchecked")
	public void bwd() {
		File file = new File("message" + File.separator + "Money_Wm.txt");	
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		String idkey = user.getAccount();
		Map<String, ArrayList<String>> map = new HashMap<>();
		map.put(idkey, list);
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
				Map<String, ArrayList<String>> map1 = new HashMap<>();
				map1 = (Map<String, ArrayList<String>>) ois.readObject();
				map1.put(idkey, list);
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