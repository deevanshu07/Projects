package com.info.service.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.info.service.DemoManager;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DemoManagerImpl implements DemoManager {

	@Override
	public String getServiceName(String name) {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getIntegerValue(int number) {
		// TODO Auto-generated method stub
		if (number == 0)
			return 0;
		else
			return 1;
	}

}



