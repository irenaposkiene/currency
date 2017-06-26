package currency;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import lt.itakademija.exam.Account;
import lt.itakademija.exam.AccountCreateException;
import lt.itakademija.exam.Bank;
import lt.itakademija.exam.Currency;
import lt.itakademija.exam.CurrencyConverter;
import lt.itakademija.exam.Customer;
import lt.itakademija.exam.CustomerCreateException;
import lt.itakademija.exam.InsufficientFundsException;
import lt.itakademija.exam.Money;
import lt.itakademija.exam.Operation;
import lt.itakademija.exam.PersonCode;
import lt.itakademija.exam.PersonName;
import lt.itakademija.exam.SequenceGenerator;

public class MyBank implements Bank {
	
	private CurrencyConverter cov;
	private List <Customer> kl= new ArrayList();
	
	private List <Account> sask= new ArrayList();
	
	private List <PersonCode> codes= new ArrayList();
	
	private SequenceGenerator customerId = new SequenceGenerator();
	private SequenceGenerator accountId = new SequenceGenerator();
	private SequenceGenerator operationId = new SequenceGenerator();
	
	public MyBank(CurrencyConverter c) {
		// TODO Auto-generated constructor stub
		c=this.cov;
	}


	@Override
	public Account createAccount(Customer c, Currency cu) {
	
	/*	if (c.equals(null)||cu.equals(null)) {
			throw new NullPointerException();
		}*/
		
		if (c==(null)||cu==(null)){
				throw new NullPointerException();
		}
		
		/*if  (!codes.contains(c.getPersonCode())) {
			throw new AccountCreateException("ERROR");
		}*/
		
		if (!kl.contains(c)) {
			throw new AccountCreateException("ERROR");
		}
		/*for (Account acc: sask) {
			if (acc.getCustomer().equals(c)) {
				throw new AccountCreateException("ERROR");
			}
		}*/
		
		Account a = new Account(accountId.getNext(), c, cu, new Money(0));
		sask.add(a);
		c.addAccount(a);;	
		// TODO Auto-generated method stub
		return a;
	}

	@Override
	public Customer createCustomer(PersonCode pc, PersonName pn) {
		// TODO Auto-generated method stub
		
		if (pc.equals(null)||pn.equals(null)) {
			throw new NullPointerException();
		}
		
		for (Customer cust :kl) {
			if (cust.getPersonCode().equals(pc)||cust.getPersonName().equals(pn)) {
				throw new CustomerCreateException("ERROR");
			}
			 
		}
		Customer c= new Customer(customerId.getNext(), pc, pn);
		kl.add(c);
		
		return c;
	}
	

	@Override
	public Money getBalance(Currency c) {
		// TODO Auto-generated method stub
	
		Money balance = null;
		for (Customer k:kl) {
		for(Account ac:k.getAccounts()) {
			if (ac.getCurrency().equals(c)) {
			balance=balance.add(ac.getBalance());
			
			/*money.add(total);*/
		}
			else {
				MyCurrencyConverter mc = null;
			/*	mc.convert(ac.getCurrency(), c, ac.getBalance()) ;*/
				balance=balance.add(mc.convert(ac.getCurrency(), c, ac.getBalance()));
				
			
		}	
		}
	
		return balance;
	}
		return balance;
	}

	@Override
	public Operation transferMoney(Account a1, Account a2, Money m) {
		// TODO Auto-generated method stub
		Money balance1=	a1.getBalance();
		Money balance2=	a2.getBalance();
		if (balance1.isGreaterThan(m)) {
			balance1.substract(m);
			balance2.add(m);
		}
		else if (balance1.isLessThan(m)){
			throw new InsufficientFundsException("ERROR");
		}
	
		return null;
	}

}
