package Administrator;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import Administrator.UserXx;
import arn.Cba;
import arn.Cqu;
import arn.Nba;

//开户
public class OpenAccount {
	public void open() {
		Scanner scanner = new Scanner(System.in);
		UserXx user = new UserXx();
		UserZz userBill = new UserZz();
		System.out.println("请选择你的性别(注意1为男2为女)\n1男            \n2女");
		Scanner sta = new Scanner(System.in);
		String dc = sta.next();
		Scanner sc = new Scanner(System.in);
		System.out.println("\n请选这你的学历\n1小学   2初中  3高中   4大学\n其他");
		Scanner next = new Scanner(System.in);
		String cb = next.next();
		System.out.println("请设置密码:(密码为8-16位,且至少包含一个阿拉伯数字,一个大写英文字母和一个小写英文字母)");
		String password;
		while (true) {
			password = scanner.nextLine();
			if (password.matches("^(?=.*[\\x00-\\xff].*)(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{8,16}$")) {
				user.setPassword(password);
				break;
			} else {
				System.out.println("密码过于简单请重新输入!");
			}
		}
		System.out.println("请输入你的家庭住址:");
		String add;
		while (true) {
			add = scanner.nextLine();
			if (add.length() <= 50) {
				user.setAddress(add);
				break;
			} else {
				System.out.println("您输入的不符合规定条件请重新输入!");
			}
		}		
		SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time = dateformat1.format(new Date(0));	
		String account = "37o" + dc + time;
		user.setAccount(account);	
		Double balance = 0.0;
		user.setBalance(balance);
		UserStockpile addUserDao = new UserStockpile(user, userBill);
		addUserDao.aaud();
		Nba nba = new Nba(user, userBill);
		nba.btd();		
		Cqu cqu = new Cqu(user, userBill);
		cqu.bdd();	
		System.out.println("你的账号为370" + account + "请牢记!");
	}
}
