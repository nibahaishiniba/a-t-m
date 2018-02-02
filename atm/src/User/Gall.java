package User;

import java.io.IOException;
import java.util.Scanner;

import Administrator.UserXx;
import Administrator.UserZz;
import atm.Atm;


public class Gall {

	private UserXx user;
	private UserZz userBill;

	public Gall(UserXx user, UserZz userBill) {
		this.user = user;
		this.userBill = userBill;
	}

	public void gum() {

		while (true) {
			System.out.println("请选择要办理的业务");
			System.out.println("1.查询\n2.转账\n3.取款\n4.存款\n5.流水\n6.退出登录");
	
			Scanner scanner = new Scanner(System.in);

			String index = scanner.next();
			if (index.equals("1")) {
				
				Useryh userQuery = new Useryh(user);
				userQuery.guq();
				System.out.println("返回上一级请按  1");
				
				while (true) {
					String returnMenu = scanner.next();
					if (returnMenu.equals("1")) {
						break;
					} else {
						System.out.println("输入有误,请重新输入!");
					}
				}
			} else if (index.equals("2")) {
				
				Transfer userTransferAccounts = new Transfer(user, userBill);

				try {
					userTransferAccounts.guta();
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}

			} else if (index.equals("3")) {
				
				Withdrawal userWithdrawMoney = new Withdrawal(user, userBill);

				userWithdrawMoney.guwm();

			} else if (index.equals("4")) {
				
				UserBa userDeposit = new UserBa(user, userBill);
				userDeposit.gwd();

			} else if (index.equals("6")) {
				
				break;
			} else {
				System.out.println("\"输入有误,请重新输入!");
			}
		}
	}

}