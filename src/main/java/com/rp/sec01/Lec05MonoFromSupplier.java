package com.rp.sec01;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import com.rp.courseutil.Util;

import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplier {

	public static void main(String[] args)
	{
		// use just method only when you have data alrd
		//Mono<String> mono=Mono.just(getName());
		//things should be lazy! 
		//do things only when it is required!
		Supplier<String> stringSupplier = () -> getName();
		Mono<String> mono = Mono.fromSupplier(stringSupplier);
		
		mono.subscribe(
				Util.onNext()
				);
		
		Callable<String> stringCallable = () -> getName();
		
		Mono.fromCallable(stringCallable)
		.subscribe(Util.onNext());
	}
	
	
	private static String getName()
	{
		System.out.println("generating name..");
		
		
		return Util.faker().name().fullName();
	}
}
