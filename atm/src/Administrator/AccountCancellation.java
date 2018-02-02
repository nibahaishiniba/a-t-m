package Administrator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
//销户
public class AccountCancellation {
	public void acl() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要删除的账号:");
		String index = scanner.nextLine();
		File file = new File("message" + File.separator + "User.txt");
		try {			
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			HashMap<String, UserXx> hashmap = (HashMap<String, UserXx>) ois.readObject();		
			Set<String> keys = hashmap.keySet();		
			for (String key : keys) {
				if (key.equals(index)) {
					hashmap.remove(index);
					FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(hashmap);
					oos.flush();
					oos.close();
					System.out.println("删除成功!");
					break;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
