package com.rp.sec03;

import java.util.concurrent.atomic.AtomicInteger;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {

	public static void main(String[] args) {
		/*Flux.generate(synchronousSink -> {
            System.out.println("emitting");
			synchronousSink.next(Util.faker().country().name());
			//synchronousSink.next(Util.faker().country().name());
           // synchronousSink.complete();
			if (Util.faker().country().name().toLowerCase().equals("singapore"))
			{
				synchronousSink.error(new RuntimeException("hey"));
			}
		})
		//.take(2)
		//remove take and see what happens
		.subscribe(Util.subscriber());*/
		//AtomicInteger a = new AtomicInteger(0);
		
		Flux.generate(synchronousSink -> {
            
			synchronousSink.next(Util.faker().country().name());
			//synchronousSink.next(Util.faker().country().name());
           // synchronousSink.complete();
			//a.incrementAndGet();
			if (Util.faker().country().name().toLowerCase().equals("singapore"))
			{
				synchronousSink.error(new RuntimeException("hey"));
			}
		})
		//.take(2)
		//remove take and see what happens
		.subscribe(Util.subscriber());
		
		
		
	}
}
