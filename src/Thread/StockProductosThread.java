package Thread;

import Jdbc.MiJdbc;

public class StockProductosThread extends Thread
{
	@Override
	public void run() {
		
		MiJdbc db = MiJdbc.getInstance();
		int delay = 3000;
		
		while(true)
		{
			
			try
			{
				Thread.sleep(delay);
				
				String sql = ""
						+ "INSERT INTO reposicion (id_producto,cantidad,fecha) "
						+ "SELECT p.id_producto, (p.unidades_stock_maximo - p.unidades_stock), CURRENT_DATE "
						+ "FROM producto p "
						+ "WHERE (p.unidades_stock < p.unidades_stock_minimo) "
						+ "AND NOT EXISTS (SELECT id_producto FROM reposicion)";
				
				int stockVerificado = db.update(sql);
				System.out.println("Pip..");
				System.out.println("Cantidad de nuevos registros de faltante de stock: "+ stockVerificado+"\n");
				
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}

		}
	}
}
