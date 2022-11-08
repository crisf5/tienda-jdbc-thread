package neoris.app;

import java.util.List;

import neoris.app.domain.Categoria;
import neoris.app.domain.Cliente;
import neoris.app.domain.Producto;

public class Main
{

	public static void main(String[] args)
	{
		Facade facade = new FacadeImpl();
		
		
//		List<Producto> productos = facade.obtenerProductos(); 
//		for(Producto dto:productos) {
//			System.out.println(dto.getId_producto()+" - "+dto.getDescripcion());
//		}
		 
		
		List<Cliente> clientes = facade.obtenerClientes();
		for(Cliente dto:clientes)
		{
			System.out.println(dto.getId_cliente()+
					" - "+ dto.getId_usuario()+
					" - "+ dto.getNombre()+
					" - "+ dto.getDireccion()+
					" - "+ dto.getId_tipo_cliente());
		}
		
//		List<Categoria> categorias = facade.obtenerCategorias();
//		for(Categoria dto:categorias) {
//			System.out.println(dto.getId_categoria()+
//					" - "+ dto.getDescripcion());
//		}
		
	}

}
