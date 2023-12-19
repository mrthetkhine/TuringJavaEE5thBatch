package com.turing.mongo.demo.scheduler;

import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduledTasks {
	/*
	@Async
	@Scheduled(fixedRate = 2000)
	public void reportCurrentTime() {
		log.info("Fixed Rate The time is now {}"+(new Date()));
		try
		{
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
	/*
	@Scheduled(initialDelay=5000,fixedDelay = 2000)
	public void runFixedDelay() {
		log.info("fixedDelay The time is now {}"+(new Date()));
		try
		{
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	*/
	@Scheduled(cron="* 21 21 * * ?")
	public void doSomething() {
		log.info("cron job The time is now {}"+(new Date()));
	}
}
