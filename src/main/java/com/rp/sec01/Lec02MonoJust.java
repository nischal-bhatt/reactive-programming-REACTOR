package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {

	 public static void main(String[] args)
	 {
	     //publisher - just like a stream
		 Mono<Integer> mono =Mono.just(10);
	 
		 //nothing happens until u subscribe
		 
		 mono.subscribe(i -> System.out.println("received" + i));
		 
	 
	 }
	 
}
