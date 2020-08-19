package ex09;

public class Box {
	private int width;
	private int length;
	private int height;
	private int volume;
	
	public int getVolume() {
		return volume;
	}
	
	public Box(int w, int l, int h){ //생성자
		this.width = w;
		this.length = l;
		this.height = h;
		volume = width * length * height;
	}

}
