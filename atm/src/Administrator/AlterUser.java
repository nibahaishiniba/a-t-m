package Administrator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import javax.jws.soap.SOAPBinding.Use;
//修改信息
public class AlterUser {
	UserXx UserXx = new UserXx();
	public void alte() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要更改的身份证号和账号:");
		String index = scanner.nextLine();
		File file = new File("message" + File.separator + "User.txt");
		try {			
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			HashMap<String, UserXx> hashmap = (HashMap<String, UserXx>) ois.readObject();		
			Set<String> keys = hashmap.keySet();		
			for (String key : keys) {
				if (key.equals(index)) {
					UserXx user = hashmap.get(key);
					here1: while (true) {						
						System.out.println("请选择要修改的选项\\n1.修改密码\\n2.退出ַ");
						String index1 = scanner.nextLine();
						String index2 = scanner.nextLine();
						if (index1.equals("1")) {
							System.out.println("请输入新的密码!(必须18位！包括大小写和数字)");
							String newPassword;							
							while (true) {
								newPassword = scanner.nextLine();
								if (newPassword.matches(
										"^(?=.*[\\x00-\\xff].*)(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{8,16}$")) {
									user.setPassword(newPassword);
									break;
								} else {
									System.out.println("密码过于简单请重新输入!");
								}
							}
							System.out.println("你的新密码为:" + newPassword);
						
								} else if (index2.equals("2")) {		
									break;
								} else {
									System.out.println("输入有误请重新输入!");
								}
							}
						
						
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