package com.rp.sec03;

import com.rp.courseutil.Util;
import com.rp.sec03.helper.NameProducer;

import reactor.core.publisher.Flux;

public class Lec08FluxPush {

	
	public static void main(String[] args)
	{
		NameProducer nameProducer = new NameProducer();

		//push is not thread safe, create is thread safe
		Flux.push(nameProducer).subscribe(Util.subscriber());
		
		Runnable runnable = () ->nameProducer.produce();
		
		for (int i =0; i< 10; i++)
		{
			new Thread(runnable).start();
		}
		
		System.out.println("main thread");
	}
}
