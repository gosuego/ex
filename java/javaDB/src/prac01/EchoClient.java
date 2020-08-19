package prac01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BufferedWriter out = null;
		Socket socket = null;
		
		try {
			socket = new Socket("localhost", 1000);
			System.out.println("서버에 접속하였습니다...");
			
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String outputMessage;
			while (true) {
				System.out.println("텍스트 입력 >> ");
				outputMessage = scanner.nextLine();
				out.write(outputMessage + "\n");
				out.flush();
				if(outputMessage.equalsIgnoreCase("끝")) {
					System.out.println("연결을 종료합니다.");
					break;
				}
			}
			socket.close();
			scanner.close();
		}catch (IOException e) {
			System.out.println("입출력 오류가 발생했습니다.");
		}
		
		
		}
	}


