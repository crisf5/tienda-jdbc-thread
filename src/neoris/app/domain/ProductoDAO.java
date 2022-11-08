package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import Jdbc.MiJdbc;

public class ProductoDAO
{
	MiJdbc db = MiJdbc.getInstance();
	
	public List<Producto> findAll(){
		
		List<Object[]> productosQuery = db.query("SELECT * FROM producto");
		
		List<Producto> listaProductos = new ArrayList<>();
		
		for(Object[] fila : productosQuery) {
			Producto list = new Producto();
			list.setId_product((Integer)fila[0]);
			list.setDescripcion((String)fila[1]);
			list.setId_proveedor((Integer)fila[2]);
			list.setId_categoria((Integer)fila[3]);
			list.setPrecio_unitario((Double)fila[4]);
			list.setUnidades_stock((Integer)fila[5]);
			list.setUnidades_stock_minimo((Integer)fila[6]);
			list.setUnidades_stock_maximo((Integer)fila[7]);
			list.setFlg_discontinuo((Integer)fila[8]);
			listaProductos.add(list);
		}
		
		return listaProductos;
	}
	
}
