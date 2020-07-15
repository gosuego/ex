package ex08;
import java.io.*;
public class Dir {
	public static void getDir(File fd) {
		
		String[] filenames = fd.list();
		for(String s : filenames) {
			File f = new File(fd,s);
			if(!f.isFile())
				System.out.println(s);
		}
	}
	public static void main(String[] args) {
		getDir(new File("c:\\"));
	}

}
