package Administrator;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

//显示信息
public class ShowUser {
	public void show() {
		File file = new File("message" + File.separator + "User.txt");
		while (true) {
			try {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				HashMap<String, ShowUser> hashmap = (HashMap<String, ShowUser>) ois.readObject();
				Set<String> keys = hashmap.keySet();

				for (String key : keys) {
					ShowUser user = (ShowUser) hashmap.get(key);
					System.out.println(user);
				}
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("返回上一层");
			Scanner scanner = new Scanner(System.in);
			String index = scanner.nextLine();
			break;
		}
	}
}