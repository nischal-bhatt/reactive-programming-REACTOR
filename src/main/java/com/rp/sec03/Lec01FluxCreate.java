package com.rp.sec03;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

	public static void main(String[] args) {
		Flux.create(fluxSunk -> {

			String country;

			do {
				country = Util.faker().country().name();
				fluxSunk.next(country);

			} while (!country.toLowerCase().equals("singapore"));

			fluxSunk.complete();
		}).subscribe(Util.subscriber());
	}
}
