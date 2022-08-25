package com.rp.sec01;

import com.rp.courseutil.Util;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

	public static void main(String[] args) {
		Mono<Integer> mono = Mono.just("ball")
				               .map(item-> item.length())
				               //.map(item -> item / 0);
                               .map(item->item/ 1);
		//mono.subscribe(item -> System.out.println(item), err -> System.out.println(err.getMessage()),
		//		() -> System.out.println("completed"));

		mono.subscribe(
				Util.onNext(),
				Util.onError(),
				Util.onComplete()
				);
		
	}
}
