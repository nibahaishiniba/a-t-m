//账号123123
//密码123456
package Administrator;
import java.util.Scanner;
public class Administrator {
	public void adm() {   
				for (int i = 3; i >= 1; i--) {
					System.out.println("请输入你的账号:");
					Scanner scanner = new Scanner(System.in);
					String admins = scanner.next();
					System.out.println("请输入密码:");
					Scanner pw = new Scanner(System.in);
					String pws=pw.next();
			    	if(!admins.equals("123123")||!pws.equals("123456")){
			    	System.out.println("密码或账号错误!请重新输入!");
						System.out.println("你还有" + (i - 1) + "次机会");
			        if(i ==0) {
			        	break;
			        }						 
			    	}else {
						System.out.println("登陆成功\n欢迎本银行系统");
						System.out.println("\n请选择你要办理的业务!\n1开户\n2销户\n3显示信息\n4修改信息\n5退出");
						while (true) {
							String Abc = scanner.next();
							if (Abc.equals("1")) {
								OpenAccount abc = new OpenAccount();
								abc.open();
								OpenAccount ne = new OpenAccount();
								   ne.open();
							} else if (Abc.equals("2")) {
								AccountCancellation zz = new AccountCancellation();
								zz.acl();
								AccountCancellation bb = new AccountCancellation();
								bb.acl();
							} else if(Abc.equals("3")) {
								ShowUser dd = new ShowUser();
								dd.show();
								ShowUser ee = new ShowUser();
								ee.show();			
							}else if(Abc.equals("4")  ) {
								AlterUser ff = new AlterUser();
								ff.alte();
								AlterUser rr = new AlterUser();
							}else if(Abc.equals("5")  ) {
								break;
							}
								System.out.println("输入有误请重新选择!");
						
					}
				}

		}

		}
		
	}

	
		
		
	

	
		
	

	
	

