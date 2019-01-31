package com.capgemini.view;

import com.capgemini.bl.Bank;
import com.capgemini.bl.InsufficientBalanceException;
import com.capgemini.bl.InvalidAccountNumberException;

public class Client {

	public static void main(String[] args) throws InvalidAccountNumberException, InsufficientBalanceException {
		Bank b=new Bank();
	try {
		System.out.println(b.createAccount(101,600));
		System.out.println(b.depositAmount(101,400));
		System.out.println(b.createAccount(102,1200));
		System.out.println(b.fundTransfer(101,102,600));
		System.out.println(b.withdrawAmount(101,100));
		System.out.println(b.showBalance(102));
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	}

}
