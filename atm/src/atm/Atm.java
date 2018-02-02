package atm;
import java.util.Scanner;
import Administrator.Administrator;
import User.UserLogin;
public class Atm{ 
	public static void main(String []args) {
		Scanner scanner = new Scanner(System.in);		
				while (true) {
					System.out.println("**************欢迎使用银行ATM系统**************");
					System.out.println("你好！请选择登陆方式：\n1；管理员登陆\n2；普通用户登陆");
					String Abc = scanner.next();
					if (Abc.equals("1")) {
						Administrator adminLogin = new Administrator();
						adminLogin.adm ();						   
					} else if (Abc.equals("2")) {
						UserLogin generalUserLogin = new UserLogin();
						generalUserLogin.uer();
					} else {
						System.out.println("输入错误,请重新输入!");
					}
				}
	  
				
		
		
	}

	
		
	}

