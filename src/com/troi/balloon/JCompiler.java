package com.troi.balloon;

import java.io.File;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class JCompiler {
	
	private static JavaCompiler compiler;
	
	public static void init() {
		System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0_71");
		compiler = ToolProvider.getSystemJavaCompiler();
	}
	
	public static void compile(File file) {
		compiler.run(null, null, null, compiler.toString());
	}
}