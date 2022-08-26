package com.rp.sec02;

import java.util.concurrent.atomic.AtomicReference;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec06Subscription {

	public static void main(String[] args) {

		AtomicReference<Subscription> atomicReference = new AtomicReference<>();

		Flux.range(1, 20).log().subscribeWith(new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription s) {
				System.out.println("received sub " + s);
				atomicReference.set(s);

			}

			@Override
			public void onNext(Integer t) {
				System.out.println("onNext " + t);

			}

			@Override
			public void onError(Throwable t) {
				System.out.println("onNext " + t.getMessage());

			}

			@Override
			public void onComplete() {
				System.out.println("completed");

			}

		});
		
		Util.sleepSeconds(3);
		
		atomicReference.get().request(3);
		Util.sleepSeconds(5);
		atomicReference.get().request(3);
		Util.sleepSeconds(5);
		System.out.println("going to cancel");
		atomicReference.get().cancel();
		Util.sleepSeconds(3);
		atomicReference.get().request(4);
	}

}
