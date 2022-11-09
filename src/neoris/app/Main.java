package neoris.app;

import java.util.List;
import java.util.Scanner;

import Thread.StockProductosThread;
import neoris.app.domain.Categoria;
import neoris.app.domain.Cliente;
import neoris.app.domain.Empleado;
import neoris.app.domain.Producto;
import neoris.app.domain.Promocion;
import neoris.app.domain.Proveedor;

public class Main
{

	public static void main(String[] args)
	{
		Facade facade = new FacadeImpl();
		try (Scanner sc=new Scanner(System.in))
		{
			int i = -1;
			while (i != 0) {
				System.out.println("Menu de Tienda");
				System.out.println("--------------");
				System.out.println("1 - Obtener info de todos los productos");
				System.out.println("2 - Obtener info de clientes que adquirieron determinado producto");
				System.out.println("3 - Obtener info de todos los clientes");
				System.out.println("4 - Obtener info de empleados que atendieron a determinado cliente");
				System.out.println("5 - Obtener info de productos con promocion vigente");
				System.out.println("6 - Obtener info de todas las promociones para determinado producto");
				System.out.println("7 - Obtener info de todas las categorias de productos");
				System.out.println("8 - Obtener info de proveedores de determinada categoria de productos");
				System.out.println("9 - Cerrar el Menu y ejecutar control de 'Reposicion de Stock'\n");

				System.out.print("Seleccione una opcion: ");
				int op = sc.nextInt();
				System.out.println("");
				
				if(op == 1) {
			
					System.out.println("Productos\n---------");
					List<Producto> productos = facade.obtenerProductos(); 
					for(Producto dto:productos) {
						System.out.println(
								"ID: "+dto.getId_producto()+
								" - Descripcion: "+dto.getDescripcion()+
								" - Precio: "+dto.getPrecio_unitario()+
								" - Stock: "+dto.getUnidades_stock());
					}
				}else if(op == 2) {
					
					System.out.print("Ingrese ID del Producto: ");
					int idProducto = sc.nextInt();
					System.out.println("");
					System.out.println("Clientes\n--------");
					List<Cliente> clientesProducto = facade.obtenerClientesQueAdquirieron(idProducto);
					for(Cliente dto: clientesProducto) {
						System.out.println("ID: "+dto.getId_cliente()+
						" - Nombre: "+ dto.getNombre()+
						" - Direccion: "+ dto.getDireccion());
					}
					
				}else if(op == 3) {
					System.out.println("Clientes\n--------");
					List<Cliente> clientes = facade.obtenerClientes();
					for(Cliente dto:clientes)
					{
						System.out.println("ID: "+dto.getId_cliente()+
						" - Nombre: "+ dto.getNombre()+
						" - Direccion: "+ dto.getDireccion());
					}
				}else if(op == 4) {
					
					System.out.print("Ingrese ID del Cliente: ");
					int idCliente = sc.nextInt();
					System.out.println("");
					System.out.println("Empleados\n---------");
					List<Empleado> empleadosAtienden = facade.obtenerEmpleadosQueAntendieron(idCliente);
					for(Empleado dto : empleadosAtienden) {
						System.out.println("ID: "+dto.getId_empleado()+
								" - "+dto.getNombre());
					}
				}else if(op == 5) {
					System.out.println("Productos\n---------");
					List<Producto> productosPromo = facade.obtenerProductosConPromocionesVigentes();
					for(Producto dto: productosPromo) {
						System.out.println("ID: "+dto.getId_producto()+
						" - Descripcion: "+dto.getDescripcion());
					}
				}else if(op == 6) {
					
					System.out.print("Ingrese ID del Producto: ");
					int idProducto = sc.nextInt();
					System.out.println("");
					System.out.println("Promociones\n-----------");
					List<Promocion> promos = facade.obtenerPromociones(idProducto);
					for(Promocion dto: promos) {
						System.out.println("ID: "+dto.getId_promocion()+
								" - Descripcion: "+dto.getDescripcion());
					}
				}else if(op == 7) {
					System.out.println("Categorias\n----------");
					List<Categoria> categorias = facade.obtenerCategorias();
					for(Categoria dto:categorias) {
						System.out.println("ID: "+dto.getId_categoria()+
								" - Descripcion: "+ dto.getDescripcion());
					}
				}else if(op == 8) {
					System.out.print("Ingrese ID de la categoria: ");
					int idCategoria = sc.nextInt();
					System.out.println("");
					System.out.println("Proveedores\n-----------");
					List<Proveedor> proveedores = facade.obtenerProveedores(idCategoria);
					for(Proveedor dto: proveedores) {
						System.out.println("ID: "+dto.getId_proveedor()+
								" - Empresa: "+ dto.getEmpresa()+
								" - Direccion: "+ dto.getDireccion()+
								" - Contacto: "+ dto.getContacto());
					}
				}else if(op == 9) {
					StockProductosThread hilo = new StockProductosThread();
					hilo.start();
					break;
				}else {
					System.out.println("Error, ingrese una opcion valida!!\n");
				}
				
				System.out.println("");	

			}
		}
			
		}
		
		

}
