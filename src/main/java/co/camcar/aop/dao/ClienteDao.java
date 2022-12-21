package co.camcar.aop.dao;

import org.springframework.stereotype.Component;

import co.camcar.aop.Cliente;

@Component
public class ClienteDao {
	
	private String valoracionClienteNormal;
	private String codigoClienteNormal;
	
	public String getValoracionClienteNormal() {
		System.out.println("getValoracionClienteNormal");
		return valoracionClienteNormal;
	}

	public void setValoracionClienteNormal(String valoracionClienteNormal) {
		System.out.println("setValoracionClienteNormal");
		this.valoracionClienteNormal = valoracionClienteNormal;
	}

	public String getCodigoClienteNormal() {
		System.out.println("getCodigoClienteNormal");
		return codigoClienteNormal;
	}

	public void setCodigoClienteNormal(String codigoClienteNormal) {
		System.out.println("setCodigoClienteNormal");
		this.codigoClienteNormal = codigoClienteNormal;
	}

	public void insertaCliente(Cliente cliente, String tipo) {
		System.out.println("Cliente insertado correctamente.");
	}

}
