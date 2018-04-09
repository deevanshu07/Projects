package com.soft.ejb;

import javax.ejb.Remote;

@Remote
public interface AnnotationDemoBeanRemote 
{
	public String show();

}
