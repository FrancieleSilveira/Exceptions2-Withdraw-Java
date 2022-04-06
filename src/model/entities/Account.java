package model.entities;

import model.exceptions.BusinessException;

public class Account {

	private Integer number;
	private String holder;
	protected Double balance = 0d;
	private Double withdrawLimit;
	
	public Account() {
	}
	
	public Account(Integer number, String holder, Double initialDeposit, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		deposit(initialDeposit);
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double initialDeposit) {
		this.balance += initialDeposit;
	}
	
	public void withdraw (Double amount) {
		validateWithdraw(amount);
		this.balance -= amount;
	}
	
	private void validateWithdraw(Double amount) {
		if (amount > getWithdrawLimit()) {
			throw new BusinessException("The amount exceeds withdraw limit");
		}
		if (amount > getBalance()) {
			throw new BusinessException("Not enough balance");
		}
	}
}
