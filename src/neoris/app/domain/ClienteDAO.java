package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import Jdbc.MiJdbc;

public class ClienteDAO
{
	MiJdbc db = MiJdbc.getInstance();
	
	public List<Cliente> obtenerClientesQueAdquirieron(int idProducto){
		
		List<Object[]> sql = db.query("");
		
		List<Cliente> listaClientes = new ArrayList<>();
		
		for(Object[]fila : sql) {
			Cliente list = new Cliente();
			
			
		}
		
		return null;
	}
}
