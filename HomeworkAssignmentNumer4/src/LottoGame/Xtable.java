package LottoGame;
/**
 ** this class creates a "Shitati" table.
 */

public class Xtable extends Table {
	 int x;
		
	
	public Xtable(int s) {
		super();
		x=s;
		
	}
	public int N()
	{
		return x;
	}
	
	public double tablePrice(){
		
		double tPrice = 0.0;
		if (isTableFull())
		{
			tPrice=(2.9)*calcolatezirofim(nSigned());	
			
		}

		return tPrice;
	}
	protected double factorial(int n){
		double fact=1;
		for (int i=1; i<=n; i++)
		fact *=i;
		return fact;
		}
	
	public double calcolatezirofim(int g)
	{
		double sum=  ( factorial(g)) /    (  (factorial (g-6)  )   *  factorial(6)  );
		
		return sum;
	}
			

}

	


