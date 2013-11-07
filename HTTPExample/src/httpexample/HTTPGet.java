/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpexample;

/**
 *
 * @author ocawley
 */

import java.io.*;
import java.net.*;

public class HTTPGet {
	// HTTP GET through socket, not through "URL" class
	public static void main ( String[] args ) throws IOException {
		Socket s = null;
		
		try {
			String host = "www.ncirl.ie";
			String file = "/Students.aspx";
			int port = 80;
			
			s = new Socket(host, port);
			
			OutputStream out = s.getOutputStream();
			PrintWriter outw = new PrintWriter(out, false);
			outw.print("GET " + file + " HTTP/1.0\r\n");
			outw.print("Accept: text/plain, text/html, text/*\r\n");
			outw.print("\r\n");
			outw.flush();
			
			InputStream in = s.getInputStream();
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			// br.close(); // Q. Do I need this?
		} 
		catch (UnknownHostException e) {} 
		catch (IOException e) {}
		
		if (s != null) {
			try {
				s.close();
			}
			catch ( IOException ioEx ) {}
		}
	}
}
    
