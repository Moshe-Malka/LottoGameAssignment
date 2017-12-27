package LottoGame;

import java.util.concurrent.ForkJoinPool;

/**
* Loto - describes a loto form - for Q1
* <p>
* The use of "protected" is done in order to ease the code writing during the exam,
* such that students will not need to put time and effort in getters and setters.
* Obviously, in a real-system you should make class variables private. Use them in
* inheriting classes through getter/setter methods.
* moshe malka id 
*/
public class Loto {

	protected final int TABLES_IN_FORM = 14;
	protected Table[] tables;

	public Loto()
	{
		tables = new Table[TABLES_IN_FORM];
		for (int i=0; i<tables.length; i++)
			tables[i] = new Table();
		
	}

	
	//***(8)*** this method gets an index number in the "tables" array,
	// and returns the table in this location.
	public Table returnTable(int i)
	{
		return tables[i]; 
	}

	//***(9)*** this method checks if the lotto form is legal.
	// by checking 3 things:
	// 1) is the table full?
	// 2) are there at least one table in "tables" array?
	// 3) is there an Even number of tables ?
	public boolean isLottoLegal()
	{	
		int n=0;
		boolean legal=false;
		for (Table a : tables) 
		{
			if(a.isTableFull())
				n=n+1;	
		}
		if(n>0&& n%2==0){
			legal=true;	
		}
		return legal;
	}

	//***(10)*** this method completes all the tables which are partly filled .
	public void completePartialTables()
	{
		for (Table a : tables)
		{
			if (a.isTableFull() == false && a.checkIfEmpty()==false)
			{
				a.completeUnsigned();
			}
		}
	}

	//***(11)*** calculates and returns the price of the form.
	public double calcLottoForm()
	{
		double lPrice = 0.0;
		for (Table b : tables) 
		{
			if (b.isTableFull()==true) 
			{
				lPrice += 2.9;
			}
		}
		return lPrice;
	}
	//***(12)*** sort the tables (full tables on top)
	public void orderTables()
	{
		Table[] t=new Table[TABLES_IN_FORM];
		for (int i=0; i<t.length; i++)
			t[i] = new Table();
		
		int i=0;
		for (int j = 0; j < tables.length; j++) 
		{
			if(tables[j].isTableFull())
			{
				t[i]=tables[j];
				i++;
			}
		}
		tables=t;
		
	}
	//***(13)*** resets all tables
	public void resetAllTables()
	{
		for (Table a : tables) {
			if(a.isTableFull()==true)
			{	
				for (int j = 1; j <38; j++)
					a.unsetNumber(j);
				for (int r = 1; r < 8; r++) 
					a.unsetStrongNumber(r);
			}
		}
	}
	//***(14)*** show all the fully signed tables.
	public void showFullTable()
	{
		for (Table e : tables)
		{
			while(e.isTableFull())
			{
				e.toString();
			}
		}
	}
	//***(Extra Method)***
	public void completeTables()
	{
		for (Table a : tables)
		{

			a.completeUnsigned();

		}
	}
	public String toString()
	{
		String tempS = "";
		for (Table z : tables)
		{
			tempS = tempS +z.toString();
		}

		return tempS;
	}
}
