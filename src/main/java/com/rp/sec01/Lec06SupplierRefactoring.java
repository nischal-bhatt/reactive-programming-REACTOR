package com.rp.sec01;

import com.rp.courseutil.Util;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

	public static void main(String[] args) throws InterruptedException
	{
		getName(); //building the pipeline!
		getName(); //building the pipeline!
	
		
		//getName().
		//subscribeOn(Schedulers.boundedElastic())
		//.subscribe(Util.onNext()); // why is this blocking?
		
		String s = getName()
				.subscribeOn(Schedulers.boundedElastic())
				.block();// this will block the main thread!
		System.out.println(s);
		getName();
		
		//Thread.sleep(8000);//block the main thread!
		//executing the pipeline!
		//executing the pipeline is where business logic is executed!
	}
	
	
	private static Mono<String> getName()
	{
		System.out.println("entered getName method");
		return Mono.fromSupplier(() -> {
			System.out.println("generating name");
			Util.sleepSeconds(3);
		  return	Util.faker().name().fullName();
		}).map(String::toUpperCase);
	}
}
