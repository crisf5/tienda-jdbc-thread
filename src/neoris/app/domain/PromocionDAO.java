package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import Jdbc.MiJdbc;

public class PromocionDAO
{
	MiJdbc db = MiJdbc.getInstance();
	
	public List<Promocion> obtenerPromociones(int idProducto){
		
		List<Object[]> sql = db.query("");
		
		List<Promocion> listaPromociones = new ArrayList<>();
		
		for(Object[] fila : sql) {
			Promocion list = new Promocion();
			list.setId_promocion((Integer)fila[0]);
			list.setDescripcion((String)fila[0]);
			listaPromociones.add(list);
		}
		return listaPromociones;
		
	}
}
