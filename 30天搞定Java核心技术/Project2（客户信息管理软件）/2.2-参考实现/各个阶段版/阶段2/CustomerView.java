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
				
				break;
			}

		} while (isFlag);

	}

	private void addNewCustomer() {

	}

	private void modifyCustomer() {

	}

	private void deleteCustomer() {

	}

	private void listAllCustomers() {

	}

	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
	}

}
