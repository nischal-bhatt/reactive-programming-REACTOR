package com.rp.sec02;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec01FluxIntro {

	 public static void main(String[] args) throws InterruptedException
	 {
		 Flux<Object> flux =Flux.just(1,2,3,4,Util.faker().name().fullName());
	     Flux<Integer> flux2 = Flux.empty();
		 
		 flux2.
		 subscribeOn(Schedulers.boundedElastic()).
		 subscribe(Util.onNext(), Util.onError(),Util.onComplete());
		 System.out.println();
		 
		 flux.
		 subscribeOn(Schedulers.boundedElastic()).
		 subscribe(Util.onNext(), Util.onError(),Util.onComplete());
		 
		 System.out.println("main thread ending?");
		 Thread.sleep(5000);
		 
	 }
}
