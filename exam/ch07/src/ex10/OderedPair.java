package ex10;

public class OderedPair<K, V> {
	private K key;
	private V value;
	
	public OderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() { return key;}
	public V getValue() { return value;}

}
