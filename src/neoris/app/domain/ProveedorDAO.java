package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import Jdbc.MiJdbc;

public class ProveedorDAO
{
	MiJdbc db = MiJdbc.getInstance();
	
	public List<Proveedor> obtenerProveedores(int idCategoria){
		
		List<Object[]> sql = db.query("");
		
		List<Proveedor> listaProveedor = new ArrayList<>();
		
		for(Object[]fila : sql) {
			Proveedor list = new Proveedor();
			list.setId_proveedor((Integer)fila[0]);
			list.setEmpresa((String)fila[1]);
			list.setContacto((String)fila[2]);
			list.setDireccion((String)fila[3]);
			listaProveedor.add(list);
		}
		
		return listaProveedor;
	}
}
