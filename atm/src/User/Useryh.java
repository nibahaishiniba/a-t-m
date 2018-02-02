package User;

import Administrator.UserXx;

public class Useryh {
	
		private UserXx user;

		public Useryh(UserXx user) {
			this.user = user;
		}

		public void guq() {

			System.out.println("账户姓名:" + user.getUserName());
			System.out.println("余额:" + user.getBalance());

		}
	}
