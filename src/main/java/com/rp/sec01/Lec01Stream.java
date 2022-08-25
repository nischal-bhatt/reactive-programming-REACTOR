package com.rp.sec01;

import java.util.stream.Stream;

public class Lec01Stream {

	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1,8,10)
				.map(i -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i * 2;
		});

		//System.out.println(stream);
		//stream is lazy
		stream.forEach(System.out::println);
	}
}
