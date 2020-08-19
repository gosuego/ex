package ex08;
import java.io.File;
public class FileEx {
	public static void listDirectory(File dir) {
		System.out.println("-------" + dir.getPath() + "의 서브 리스트 입니다.------");
		
		File[] subFiles = dir.listFiles();
		
		for(int i = 0; i<subFiles.length; i++) {
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());
			System.out.print("\t파일 크기: " + f.length());
			System.out.printf("\t수정한 시간: %tb %td %ta %tT\n",t, t, t, t);
		}
	}
	public static void main(String[] args) {
		File f1 =new File("c:\\windoes\\system.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());
		
		String res = "";
		if(f1.isFile()) res = "파일";
		else if(f1.isDirectory()) res = "디렉토리";
		System.out.println(f1.getPath() + "은 " + res + "입니다.");
		
		File f2 = new File("c:\\Temp\\java_sample");
		if(!f2.exists()) {
			f2.mkdir();
		}
		listDirectory(new File("c:\\Temp"));
		f2.renameTo(new File("c:\\Temp\\javasample"));
		
		listDirectory(new File("c:\\Temp"));
	}

}
