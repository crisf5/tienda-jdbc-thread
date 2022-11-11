package neoris.app;

import java.util.List;

import neoris.app.domain.Categoria;
import neoris.app.domain.CategoriaDAO;
import neoris.app.domain.Cliente;
import neoris.app.domain.ClienteDAO;
import neoris.app.domain.Empleado;
import neoris.app.domain.EmpleadoDAO;
import neoris.app.domain.Producto;
import neoris.app.domain.ProductoDAO;
import neoris.app.domain.Promocion;
import neoris.app.domain.PromocionDAO;
import neoris.app.domain.Proveedor;
import neoris.app.domain.ProveedorDAO;

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
		ClienteDAO cliente = new ClienteDAO();
		return cliente.obtenerClientesQueAdquirieron(idProducto);
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
		EmpleadoDAO empleado = new EmpleadoDAO();		
		return empleado.obtenerEmpleadosQueAntendieron(idCliente);
	}

	@Override
	public List<Producto> obtenerProductosConPromocionesVigentes()
	{
		ProductoDAO producto = new ProductoDAO();
		return producto.obtenerProductosConPromocionesVigentes();
	}

	@Override
	public List<Promocion> obtenerPromociones(int idProducto)
	{
		PromocionDAO promocion = new PromocionDAO();
		return promocion.obtenerPromociones(idProducto);
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
		ProveedorDAO proveedor = new ProveedorDAO();
		return proveedor.obtenerProveedores(idCategoria);
	}

	@Override
	public void generarReposicionProducto()
	{
		ProductoDAO productos = new ProductoDAO();
		productos.generarReposicionProducto();
		
	}
	
}
