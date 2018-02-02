package arn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Administrator.UserXx;
import Administrator.UserZz;

public class Nba {

	private UserXx user;
	private UserZz UserZz;

	public Nba(UserXx user2, Administrator.UserZz userBill) {
	}

	public void nba(UserXx user, UserZz userz) {
		this.user = user;
		this.UserZz = userz;
	}

	public void btd() {

		File file = new File("txt" + File.separator + "User.txt");
		
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
