package ex13;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LineEventEx extends JFrame{
	private Clip clip;
	private String song = "audio/애국가1절.wav";
	private JLabel label = new JLabel(song);
	
	public LineEventEx() {
		setTitle("애국가 1절 연주");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.YELLOW);
		c.add(label);
		setSize(300, 150);
		setVisible(true);
		loadAudio(song);
	}
	
	private void loadAudio(String pathName) {
		try {
			File audioFile = new File(pathName);
			final AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip = AudioSystem.getClip();
			clip.addLineListener(new LineListener() {
				public void update(LineEvent e) {
					if(e.getType() == LineEvent.Type.STOP) {
						try {
							getContentPane().setBackground(Color.orange);
							label.setText(song+"연주 끝!");
							audioStream.close();
						}catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			clip.open(audioStream);
			clip.start();
		}
		catch (LineUnavailableException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();} catch (UnsupportedAudioFileException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new LineEventEx();
	}

}
