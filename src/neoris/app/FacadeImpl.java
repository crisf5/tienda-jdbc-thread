package neoris.app;

import java.util.List;

import neoris.app.domain.Categoria;
import neoris.app.domain.CategoriaDAO;
import neoris.app.domain.Cliente;
import neoris.app.domain.ClienteDAO;
import neoris.app.domain.Empleado;
import neoris.app.domain.Producto;
import neoris.app.domain.ProductoDAO;
import neoris.app.domain.Promocion;
import neoris.app.domain.Proveedor;

public class FacadeImpl implements Facade
{

	@Override
	public List<Producto> obtenerProductos()
	{
		ProductoDAO producto = new ProductoDAO();
		return producto.findAll();
	}

	@Override
	public List<Cliente> obtenerClientesQueAdquirieron(int idProducto)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> obtenerClientes()
	{
		ClienteDAO cliente = new ClienteDAO();
		return cliente.findAll();
	}

	@Override
	public List<Empleado> obtenerEmpleadosQueAntendieron(int idCliente)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> obtenerProductosConPromocionesVigentes()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promocion> obtenerPromociones(int idProducto)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> obtenerCategorias()
	{
		CategoriaDAO categoria = new CategoriaDAO();
		return categoria.findAll();
	}

	@Override
	public List<Proveedor> obtenerProveedores(int idCategoria)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generarReposicionProducto()
	{
		// TODO Auto-generated method stub
		
	}
	
}
