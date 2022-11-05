package neoris.app.domain;

public class Producto
{
	private Integer id_product;
	private String descripcion;
	private Integer id_proveedor;
	private Integer id_categoria;
	private Double precio_unitario;
	private Integer unidades_stock;
	private Integer unidades_stock_minimo;
	private Integer unidades_stock_maximo;
	private Integer flg_discontinuo;
	
	public Integer getId_product()
	{
		return id_product;
	}
	public void setId_product(Integer id_product)
	{
		this.id_product=id_product;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion=descripcion;
	}
	public Integer getId_proveedor()
	{
		return id_proveedor;
	}
	public void setId_proveedor(Integer id_proveedor)
	{
		this.id_proveedor=id_proveedor;
	}
	public Integer getId_categoria()
	{
		return id_categoria;
	}
	public void setId_categoria(Integer id_categoria)
	{
		this.id_categoria=id_categoria;
	}
	public Double getPrecio_unitario()
	{
		return precio_unitario;
	}
	public void setPrecio_unitario(Double precio_unitario)
	{
		this.precio_unitario=precio_unitario;
	}
	public Integer getUnidades_stock()
	{
		return unidades_stock;
	}
	public void setUnidades_stock(Integer unidades_stock)
	{
		this.unidades_stock=unidades_stock;
	}
	public Integer getUnidades_stock_minimo()
	{
		return unidades_stock_minimo;
	}
	public void setUnidades_stock_minimo(Integer unidades_stock_minimo)
	{
		this.unidades_stock_minimo=unidades_stock_minimo;
	}
	public Integer getUnidades_stock_maximo()
	{
		return unidades_stock_maximo;
	}
	public void setUnidades_stock_maximo(Integer unidades_stock_maximo)
	{
		this.unidades_stock_maximo=unidades_stock_maximo;
	}
	public Integer getFlg_discontinuo()
	{
		return flg_discontinuo;
	}
	public void setFlg_discontinuo(Integer flg_discontinuo)
	{
		this.flg_discontinuo=flg_discontinuo;
	}
	
	
}
