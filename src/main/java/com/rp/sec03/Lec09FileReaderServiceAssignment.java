package com.rp.sec03;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.rp.courseutil.Util;
import com.rp.sec03.assignment.FileReaderService;

public class Lec09FileReaderServiceAssignment {

	public static void main(String[] args) {
		FileReaderService readerService = new FileReaderService();

		Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");
		readerService.read(path)
		.map(s -> {
			Integer integer = Util.faker().random().nextInt(0,10);
			if (integer > 8)
			{
				throw new RuntimeException("heyyaaaaa");
			}
			return s;
		})
		.take(5).subscribe(Util.subscriber());
	}
}
