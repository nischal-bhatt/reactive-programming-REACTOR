package com.rp.sec02;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

	public static void main(String[] args) throws InterruptedException
	{
		Mono<String> mono = Mono.just("A");
		
		Flux<String> f = Flux.from(mono);
		
		doSomething(f);
		Thread.sleep(6000);
		
		Flux.range(1, 10)
		.filter(himesh -> himesh > 3)
		.next() //converts to a mono
		.subscribe(Util.onNext());
		
		
	}
	
	
	private static void doSomething(Flux<String> flux)
	{
		flux
		.subscribe(Util.onNext());
		
	}
}
