package com.rp.sec02;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec05FluxRange {

	public static void main(String[] args) {
		Flux.range(7, 8).log().map(o -> Util.faker().name().fullName()).log().subscribe(Util.onNext(), Util.onError(),
				Util.onComplete());
	}
}
