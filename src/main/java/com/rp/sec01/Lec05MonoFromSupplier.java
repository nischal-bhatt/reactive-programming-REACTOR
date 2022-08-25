package com.rp.sec01;

import com.rp.courseutil.Util;

import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplier {

	public static void main(String[] args)
	{
		// use just method only when you have data alrd
		//Mono<String> mono=Mono.just(getName());
		//things should be lazy! 
		//do things only when it is required!
		Mono<String> mono = Mono.fromSupplier(() -> getName());
		
		mono.subscribe(
				Util.onNext()
				);
	}
	
	
	private static String getName()
	{
		System.out.println("generating name..");
		
		
		return Util.faker().name().fullName();
	}
}
