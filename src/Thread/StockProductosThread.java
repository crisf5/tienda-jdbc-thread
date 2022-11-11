package Thread;

import neoris.app.domain.ProductoDAO;

public class StockProductosThread extends Thread
{
	@Override
	public void run() {
		
		int delay = 3000;
		ProductoDAO productos = new ProductoDAO();
		
		while(true)
		{
			
			try
			{
				Thread.sleep(delay);
				productos.generarReposicionProducto();
		
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}

		}
	}
}
