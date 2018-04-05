
package com.info.eventhandler;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class CSStartEventHandler implements ApplicationListener<ContextStartedEvent> {

	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Event started");
	}

}
