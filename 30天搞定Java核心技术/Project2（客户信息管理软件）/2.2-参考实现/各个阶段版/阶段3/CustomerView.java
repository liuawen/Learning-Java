package com.atguigu.client;

public class CustomerView {

	private CustomerList custList = new CustomerList(10);

	public void enterMainMenu() {

		boolean isFlag = true;

		do {
			System.out
					.println("\n-----------------客户信息管理软件-----------------\n");
			System.out.println("                   1 添 加 客 户");
			System.out.println("                   2 修 改 客 户");
			System.out.println("                   3 删 除 客 户");
			System.out.println("                   4 客 户 列 表");
			System.out.println("                   5 退       出\n");
			System.out.print("                   请选择(1-5)：");

			// 从键盘获取用户1-5的选择
			char menu = CMUtility.readMenuSelection();
			// 使用switch-case对用户的选择，进行区别处理
			switch (menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.print("确认是否退出(Y/N)：");
				char exit = CMUtility.readConfirmSelection();
				if (exit == 'Y') {
					isFlag = false;
				}
				break;
			}

		} while (isFlag);

	}

	private void addNewCustomer() {
		System.out.println("---------------------添加客户---------------------");
		System.out.print("姓名：");
		String name = CMUtility.readString(5);
		System.out.print("性别：");
		char gender = CMUtility.readChar();
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		System.out.print("电话：");
		String phone = CMUtility.readString(15);
		System.out.print("邮箱：");
		String email = CMUtility.readString(20);

		// 封装为一个对象
		Customer customer = new Customer(name, gender, age, phone, email);
		// 将此对象添加到CustomerList里的数组中
		boolean flag = custList.addCustomer(customer);
		if (flag) {
			System.out
					.println("---------------------添加完成---------------------");

		} else {
			System.out.println("人数已达上限，添加失败！");
		}
	}

	private void modifyCustomer() {

	}

	private void deleteCustomer() {

	}

	/**
	 * 获取客户列表
	 */
	private void listAllCustomers() {
		System.out
				.println("---------------------------客户列表---------------------------");
		// 获取所有的客户
		Customer[] customers = custList.getAllCustomers();
		if (customers.length == 0) {
			System.out.println("没有任何客户记录！");

		} else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
			for (int i = 0; i < customers.length; i++) {
				Customer cust = customers[i];
				// 方式一：
				// System.out.println((i + 1) + "\t" + cust.getName() + "\t"
				// + cust.getGender() + "\t" + cust.getAge() + "\t"
				// + cust.getPhone() + "\t\t" + cust.getEmail());
				// 方式二：
				System.out.println((i + 1) + "\t" + cust.info());

			}
		}
		System.out
				.println("-------------------------客户列表完成-------------------------");

	}

	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
	}

}
