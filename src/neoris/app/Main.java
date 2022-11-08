package neoris.app;

import java.util.List;

import neoris.app.domain.Producto;

public class Main
{

	public static void main(String[] args)
	{
		Facade facade = new FacadeImpl();
		
		List<Producto> productos = facade.obtenerProductos();
		for(Producto dto:productos)
		{
			System.out.println(dto.getId_producto()+" - "+dto.getDescripcion());
		}
	}

}
