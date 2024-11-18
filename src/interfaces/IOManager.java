package interfaces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public interface IOManager {
	public StringBuffer buffer = new StringBuffer();
	public BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void append(String str) {
		try {
			buffer.append(str);
			writer.append(buffer);
			writer.flush();
			buffer.setLength(0);
		} catch (IOException e) {
		}
	}
}