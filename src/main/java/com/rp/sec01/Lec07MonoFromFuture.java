package com.rp.sec01;

import java.util.concurrent.CompletableFuture;

import com.rp.courseutil.Util;

import reactor.core.publisher.Mono;

public class Lec07MonoFromFuture {

	public static void main(String[] args)
	{
		Mono.fromFuture(getName())
		.subscribe(Util.onNext());
		
		
		Util.sleepSeconds(1); //block the main thread
	}
	
	private static CompletableFuture<String> getName() {
		return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
	}
}
