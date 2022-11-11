package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import Jdbc.MiJdbc;

public class ProductoDAO
{
	MiJdbc db = MiJdbc.getInstance();
	
	public List<Producto> datosProducto(List<Object[]> sql){
		
		List<Producto> listaProductos = new ArrayList<>();
		
		for(Object[] fila : sql) {
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
	
	public List<Producto> findAll(){
		
		List<Object[]> sql = db.query("SELECT * FROM producto");
		
		List<Producto> listaProductos = datosProducto(sql);
		
		return listaProductos;
	}
	
	
	public List<Producto> obtenerProductosConPromocionesVigentes(){
		
		List<Object[]> sql = db.query(""
				+ "SELECT p.* FROM producto p, promocion_producto d, promocion_vigencia v "
				+ "WHERE v.fecha_fin > CURRENT_DATE "
				+ "AND v.id_promocion_vigencia = d.id_promocion_vigencia "
				+ "AND d.id_producto = p.id_producto");
		
		List<Producto> listaProductos = datosProducto(sql);
		
		return listaProductos;
	}
	
	public void generarReposicionProducto() {
		
		String sql = ""
				+ "INSERT INTO reposicion (id_producto,cantidad,fecha) "
				+ "SELECT p.id_producto, (p.unidades_stock_maximo - p.unidades_stock), CURRENT_DATE "
				+ "FROM producto p "
				+ "WHERE (p.unidades_stock < p.unidades_stock_minimo) "
				+ "AND NOT EXISTS (SELECT id_producto FROM reposicion)";
		
		int stockVerificado = db.update(sql);
		System.out.println("Pip..");
		System.out.println("Cantidad de nuevos registros de faltante de stock: "+ stockVerificado+"\n");
	}
	
}
