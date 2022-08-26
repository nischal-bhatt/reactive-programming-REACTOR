package com.rp.sec01;

import com.rp.courseutil.Util;
import com.rp.sec01.assignment.FileService;

public class Lec09AssignmentDemo {

	public static void main(String[] args) throws InterruptedException
	{
		
		FileService.delete("file01.txt")
		.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
		//this is still blocking!
		;
		
		Thread.sleep(7000);
		
		FileService.read("file03.txt")
		.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
		
		
		FileService.write("file04.txt","this is file5")
		.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
		
		
		System.out.println("finished");
	}
}
