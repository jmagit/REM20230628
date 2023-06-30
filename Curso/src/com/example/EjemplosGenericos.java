package com.example;

public class EjemplosGenericos {

	public EjemplosGenericos() {
		// TODO Auto-generated constructor stub
	}

	public static class Elemento<K, V> {
		private K key;
		private V value;

		public Elemento(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}
		public void setKey(K value) {
			key = value;
		}

		public V getValue() {
			return value;
		}
	}
//	public static class Elemento {
//		private Object key;
//		private String value;
//
//		public Elemento(Object key, String value) {
//			super();
//			this.key = key;
//			this.value = value;
//		}
//
//		public Object getKey() {
//			return key;
//		}
//		public void setKey(Object value) {
//			key = value;
//		}
//
//		public String getValue() {
//			return value;
//		}
//	}
	
	public static class ElementoInt {
		private int key;
		private String value;

		public ElementoInt(int key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}
		public void setKey(int value) {
			key = value;
		}

		public String getValue() {
			return value;
		}
	}
	public static class ElementoChar {
		private char key;
		private String value;

		public ElementoChar(char key, String value) {
			this.key = key;
			this.value = value;
		}

		public char getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
	}

}
