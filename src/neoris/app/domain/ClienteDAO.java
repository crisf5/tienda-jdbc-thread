package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import Jdbc.MiJdbc;

public class ClienteDAO
{
	MiJdbc db = MiJdbc.getInstance();
	
	public List<Cliente> datosCliente(List<Object[]> sql){
		
		List<Cliente> listaClientes = new ArrayList<>();
		
		for(Object[] fila : sql) {
			Cliente list = new Cliente();
			list.setId_cliente((Integer)fila[0]);
			list.setId_usuario((Integer)fila[1]);
			list.setNombre((String)fila[2]);
			list.setDireccion((String)fila[3]);
			list.setId_tipo_cliente((Integer)fila[4]);
			listaClientes.add(list);
		}
		
		return listaClientes;
	}
	
	
	public List<Cliente> findAll(){
		
		List<Object[]> sql = db.query("SELECT * FROM cliente");
		
		List<Cliente> listaClientes = datosCliente(sql);
		
		return listaClientes;
	}
	
	
	public List<Cliente> obtenerClientesQueAdquirieron(int idProducto){
		
		List<Object[]> sql = db.query(""
				+ "SELECT c.* FROM cliente c, orden o, detalle_orden d "
				+ "WHERE d.id_producto = ? "
				+ "AND d.id_orden = o.id_orden "
				+ "AND o.id_cliente = c.id_cliente",idProducto);
		
		List<Cliente> listaClientes = datosCliente(sql);
		
		return listaClientes;
	}
}
