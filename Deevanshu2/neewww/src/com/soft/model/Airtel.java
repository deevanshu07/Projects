package com.soft.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Airtel extends Remote
{
	public String getBalance(Customer customer) throws RemoteException;

}
