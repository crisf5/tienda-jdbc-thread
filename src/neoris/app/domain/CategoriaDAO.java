package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import Jdbc.MiJdbc;

public class CategoriaDAO
{
	MiJdbc db = MiJdbc.getInstance();
	
	public List<Categoria> findAll(){
		
		List<Object[]> sql = db.query("SELECT * FROM categoria");
		
		List<Categoria> listaCategorias = new ArrayList<>();
		
		for(Object[] fila : sql) {
			Categoria list = new Categoria();
			list.setId_categoria((Integer)fila[0]);
			list.setDescripcion((String)fila[1]);
			listaCategorias.add(list);
		}
		
		return listaCategorias;
	}
}
