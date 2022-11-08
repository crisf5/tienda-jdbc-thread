package neoris.app;

import java.util.List;

import neoris.app.domain.Categoria;
import neoris.app.domain.Cliente;
import neoris.app.domain.Empleado;
import neoris.app.domain.Producto;

public class Main
{

	public static void main(String[] args)
	{
		Facade facade = new FacadeImpl();
		
		
//		List<Producto> productos = facade.obtenerProductos(); 
//		for(Producto dto:productos) {
//			System.out.println(dto.getId_producto()+
//					" - "+dto.getDescripcion()+
//					" - "+dto.getPrecio_unitario()+
//					" - "+dto.getUnidades_stock()+
//					" - "+dto.getFlg_discontinuo());
//		}
		 
		
//		List<Cliente> clientes = facade.obtenerClientes();
//		for(Cliente dto:clientes)
//		{
//			System.out.println(dto.getId_cliente()+
//					" - "+ dto.getId_usuario()+
//					" - "+ dto.getNombre()+
//					" - "+ dto.getDireccion()+
//					" - "+ dto.getId_tipo_cliente());
//		}
		
		List<Empleado> empleadosAtienden = facade.obtenerEmpleadosQueAntendieron(2);
		for(Empleado dto : empleadosAtienden) {
			System.out.println(dto.getId_empleado()+
					" - "+dto.getNombre()+
					" - "+dto.getId_jefe());
		}
		
//		List<Categoria> categorias = facade.obtenerCategorias();
//		for(Categoria dto:categorias) {
//			System.out.println(dto.getId_categoria()+
//					" - "+ dto.getDescripcion());
//		}
		
	}

}
