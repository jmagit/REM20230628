package com.example;

import java.util.ArrayList;
import java.util.List;

public class Factura {
	public enum Estado {
		PENDIENTE, PAGADA, CANCELADA
	}
	public class Linea {
		private int numero;
		private int idProducto;
		private int cantidad;
		private double precioUnitario;
		private Linea(int numero, int idProducto, int cantidad, double precioUnitario) {
			super();
			this.numero = numero;
			this.idProducto = idProducto;
			this.cantidad = cantidad;
			this.precioUnitario = precioUnitario;
		}
		public int getNumero() {
			return numero;
		}
		public void setNumero(int numero) {
			this.numero = numero;
		}
		public int getIdProducto() {
			return idProducto;
		}
		public void setIdProducto(int idProducto) {
			this.idProducto = idProducto;
		}
		public int getCantidad() {
			return cantidad;
		}
		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		public double getPrecioUnitario() {
			return precioUnitario;
		}
		public void setPrecioUnitario(double precioUnitario) {
			this.precioUnitario = precioUnitario;
		}
		public int getNumeroFactura() {
			return numeroFactura;
		}
		@Override
		public String toString() {
			return "Linea [numero=" + numero + ", idProducto=" + idProducto + ", cantidad=" + cantidad
					+ ", precioUnitario=" + precioUnitario + ", NumeroFactura=" + getNumeroFactura() + "]";
		}
	}
	private int numeroFactura;
	// ...
	private List<Linea> lineas;
	
	public Factura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
		lineas = new ArrayList<>();
	}
	public int getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public List<Linea> getLineas() {
		return lineas;
	}
	public void setLineas(List<Linea> lineas) {
		this.lineas = lineas;
	}
	public void addLinea(int numero, int idProducto, int cantidad, double precioUnitario) {
		this.lineas.add(new Linea(numero, idProducto, cantidad, precioUnitario));
	}
	
}
