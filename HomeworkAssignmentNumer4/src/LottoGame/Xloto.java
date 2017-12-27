package LottoGame;
/**
 ** this class creates a "Shitati" lotto form. (uses Xtable) .
 */

public class Xloto extends Loto {
	
	protected Xtable[] xtables;

	int f;
	public Xloto(int f)
	{
		super();
		xtables = new Xtable[TABLES_IN_FORM];
		for (int i=0; i<tables.length; i++)
			xtables[i] = new Xtable(f);
		
	}
	public void CompleteTable()
	{
			for (Xtable a : xtables)
			{
				if (a.isTableFull() == false && a.checkIfEmpty()==false)
				{
					a.completeUnsigned();
				}
			}
		

	}
	public double calcLottoForm()
	{
		double x = 0.0;
		for (Xtable z : xtables)
		{
			if(z.isTableFull())
			x=x+z.tablePrice();
		}

		return x;
	}
	public String toString()
	{
		String tempS = "";
		for (Xtable z : xtables)
		{
			tempS = tempS +z.toString();
		}

		return tempS;
	}
	public void orderTables()
	{
		Xtable[] t=new Xtable[TABLES_IN_FORM];
		for (int i=0; i<t.length; i++)
			t[i] = new Xtable(f);
		
		int i=0;
		for (int j = 0; j < tables.length; j++) 
		{
			if(xtables[j].isTableFull())
			{
				t[i]=xtables[j];
				i++;
			}
		}
		xtables=t;
		
	}
	
	public boolean isLottoLegal(){
		boolean legal=false;
		for (Table a : tables) 
		{
			if(a.isTableFull())
				legal=true;
			
			
		}
		return legal;
	}
	
	
}
