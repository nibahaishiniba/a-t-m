package User;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import Administrator.UserXx;
import Administrator.UserZz;

public class Withdrawal {
	private UserXx user;
	private UserZz userBill;
	public Withdrawal(UserXx user, UserZz userBill) {
		this.user = user;
		this.userBill = userBill;
	}
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
	String wt = sdf.format(new Date(0));
	Scanner scanner = new Scanner(System.in);
	public void guwm() {
		here: while (true) {
			System.out.println("请输入取款金额:");
			double wIndex = scanner.nextDouble();
			if (wIndex % 100 == 0 && wIndex <= user.getBalance()) {
				here1: while (true) {
					System.out.println("1.确认\n2.重新输入\n3.返回主菜单");
					String wIndex2 = scanner.next();
					while (true) {
						if (wIndex2.equals("1")) {
							userBill.setBalance_w(user.getBalance());
							double bal = user.getBalance() - wIndex;
							user.setBalance(bal);
							userBill.setwTime(wt);
							Bal basedao = new Bal(user, userBill);
							basedao.bd();							
							UserBa wmdao = new UserBa(user, userBill);
							wmdao.gwd();
							System.out.println("成功取款:" + wIndex + "元");
							System.out.println("存款时间:" + wt);
							System.out.println("取款成功,正在返回主菜单!");
							System.out.println("返回主菜单成功!");
							break here;
						} else if (wIndex2.equals("2")) {
							break here1;
						} else if (wIndex2.equals("3")) {
							System.out.println("正在返回主菜单!");
							System.out.println("返回主菜单成功!");
							break here;
						} else {
							System.out.println("输入有误,请重新输入!");
							break;
						}
					}
					continue;
				}
			} else if (wIndex % 100 != 0 && wIndex <= user.getBalance()) {
				System.out.println("请输入100的整数倍取款金额!");

			} else if (wIndex % 100 != 0 && wIndex > user.getBalance()) {
				System.out.println("余额不足,请输入100的整数倍取款金额!");

			} else if (wIndex % 100 == 0 && wIndex > user.getBalance()) {
				System.out.println("余额不足!");

			} else {
				System.out.println("��������,����������!");
			}
		}
	}
}
