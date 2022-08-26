package com.rp.sec03;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {

	public static void main(String[] args) {
		Flux.create(fluxSunk -> {

			String country;

			do {
				country = Util.faker().country().name();
				System.out.println("pushing: " + country);
				fluxSunk.next(country);

			} while (!country.toLowerCase().equals("singapore") && !fluxSunk.isCancelled());

			fluxSunk.complete();
		}).take(3).subscribe(Util.subscriber());
	}
}
