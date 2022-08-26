package com.rp.sec02;

import java.util.Arrays;
import java.util.List;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec03FluxFromArrayOrList {

	public static void main(String[] args) {
		
		List<String> strings = Arrays.asList("a","b","c");

		
		Flux.fromIterable(strings)
		.subscribe(Util.onNext());
		
		
		Integer[] arr = {2,3,6,8};
		
		Flux.fromArray(arr)//this is just like just
		.subscribe(Util.onNext());
	}
}
