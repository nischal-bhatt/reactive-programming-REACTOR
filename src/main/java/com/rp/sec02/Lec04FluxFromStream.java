package com.rp.sec02;

import java.util.List;
import java.util.stream.Stream;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec04FluxFromStream {

	 public static void main(String[] args)
	 {
		List<Integer> list= List.of(1,2,3,4,5);
		
		Stream<Integer> stream = list.stream();
		
		//stream.forEach(System.out::println); // closed
		//stream.forEach(System.out::println);
		
	//	Flux<Integer> intergerFlux=Flux.fromStream(stream);
		
		Flux<Integer> intergerFlux = Flux.fromStream(() -> list.stream());
		
		intergerFlux 
		.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
	 
	 
		intergerFlux 
		.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
	 }
}
