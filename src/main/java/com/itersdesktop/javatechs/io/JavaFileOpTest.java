package com.itersdesktop.javatechs.io;

import java.nio.file.*;

public class JavaFileOpTest {
	public static void main(String[] args) {
		System.out.println("Testing methods of Java File Operations.");
		testPathResolve();
	}

	private static void testPathResolve() {
		// create an object of Path 
        Path path = Paths.get("/tmp/JavaOP"); 
  
        // create a string object 
        String passedPath = "drive"; 
  
        // call resolve() to create resolved Path 
        Path resolvedPath = path.resolve(passedPath); 
  
        // print result 
        System.out.println("Resolved Path: " + resolvedPath);
	}
}