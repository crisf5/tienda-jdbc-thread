package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import Jdbc.MiJdbc;

public class PromocionDAO
{
	MiJdbc db = MiJdbc.getInstance();
	
	public List<Promocion> obtenerPromociones(int idProducto){
		
		List<Object[]> sql = db.query(""
				+ "SELECT d.* FROM promocion_producto prom, promocion_vigencia v, promocion d "
				+ "WHERE prom.id_producto = ? "
				+ "AND v.id_promocion_vigencia = prom.id_promocion_vigencia "
				+ "AND d.id_promocion = v.id_promocion",idProducto);
		
		List<Promocion> listaPromociones = new ArrayList<>();
		
		for(Object[] fila : sql) {
			Promocion list = new Promocion();
			list.setId_promocion((Integer)fila[0]);
			list.setDescripcion((String)fila[1]);
			listaPromociones.add(list);
		}
		return listaPromociones;
		
	}
}
