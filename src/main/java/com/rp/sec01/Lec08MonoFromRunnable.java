package com.rp.sec01;

import com.rp.courseutil.Util;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec08MonoFromRunnable {

	
	public static void main(String[] args) throws InterruptedException
	{
		Runnable runnable = () -> System.out.println("");
		
		Mono.fromRunnable(timeConsumingProcess())
		.subscribeOn(Schedulers.boundedElastic()) //makes another thread
		.subscribe(Util.onNext(), Util.onError(), 
				() -> {
					System.out.println("process is done, sending emails...");
				}
				
				);
		
				System.out.println("hello");
				Thread.sleep(3000);
	}
	
	
	private static Runnable timeConsumingProcess() {
		return () -> {
			Util.sleepSeconds(3);
			System.out.println("operation completed");
		};
	}
}
