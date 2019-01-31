package com.capgemini.bl;

import java.util.LinkedList;

import com.capgemini.beans.Account;

public class Bank {
LinkedList<Account> ac=new LinkedList<>();
public String createAccount(int accountNumber,int amount)
{
	Account accounts=new Account(accountNumber, amount);
	ac.add(accounts);
	if(accounts.getAmount()<500)
		return "Minimum Balance should be 500 to create an account";
	else
		return "Account created successfully. ThankYou for your interest in our banking. Your balance is "+accounts.getAmount();
}
private Account searchAccount(int accountNumber) throws InvalidAccountNumberException
{
	for(Account accounts:ac)
	{
		if(accounts.getAccountNumber()==accountNumber)
		{
			return accounts;
		}
	}
	throw new InvalidAccountNumberException("Invalid Acccount Number");
}
public String withdrawAmount(int accountNumber,int amount)throws InvalidAccountNumberException,InsufficientBalanceException
{
	Account account=searchAccount(accountNumber);
	if((account.getAmount()-amount)>=500)
	{
		account.setAmount(account.getAmount()-amount);
		return "Updated Balance of account number "+account.getAccountNumber()+" is "+account.getAmount();
	}
	throw new InsufficientBalanceException();
}
public String depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException
{
	Account account=searchAccount(accountNumber);
	account.setAmount(account.getAmount()+amount);
	return "Updated Balance of account number "+account.getAccountNumber()+" is "+account.getAmount();
}
public String fundTransfer(int accountNumberFrom,int accountNumberTo,int amount)throws InsufficientBalanceException,InvalidAccountNumberException
{
	Account account=searchAccount(accountNumberFrom);
	if((account.getAmount()-amount)>=500)
	{
		Account ac=searchAccount(accountNumberTo);
		if(account.getAccountNumber()==ac.getAccountNumber())
			return "**ERROR**Both account number cannot be same";
		else
		{
		ac.setAmount(ac.getAmount()+amount);
		account.setAmount(account.getAmount()-amount);
		return "Fund transferred Successfully from "+account.getAccountNumber()+"[Updated Balance="+account.getAmount()+"] to "+ac.getAccountNumber()+"[Updated Balance="+ac.getAmount()+"]";
	}
	}
	else
	throw new InsufficientBalanceException("Remaining Balance should be 500 or greater than 500");
}
public String showBalance(int accountNumber)throws InvalidAccountNumberException
{
	Account ac=searchAccount(accountNumber);
	return "Balance of account number "+ac.getAccountNumber()+" is "+ac.getAmount();
}
}
