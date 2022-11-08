package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import Jdbc.MiJdbc;

public class EmpleadoDAO
{
	MiJdbc db = MiJdbc.getInstance();
	
	public List<Empleado> obtenerEmpleadosQueAntendieron(int idCliente){
		
		List<Object[]> sql = db.query("");
		
		List<Empleado> listaEmpleados = new ArrayList<>();
		
		for(Object[] fila : sql) {
			Empleado list = new Empleado();
			list.setId_empleado((Integer)fila[0]);
			list.setNombre((String)fila[1]);
			list.setId_jefe((Integer)fila[2]);
			listaEmpleados.add(list);
		}
		
		return listaEmpleados;
	}
}
