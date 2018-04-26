package com.soft.classes;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Test extends Remote
{
	public String show() throws RemoteException;

}
