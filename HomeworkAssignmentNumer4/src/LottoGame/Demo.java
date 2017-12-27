package LottoGame;
/**
 ** @author :
 ** Moshe Malka 300709797	
 ** Dekel Laifer 203943436 
 *
 *<p>
 *
 *	this class runs the program .
 *
 *<p>
 *
 * *** Exsample of a run ***
 * <p>
 * {3,5,6,7,11,17,|1}
<p>
price 2.9<p>
{4,7,10,27,35,37,|4}
<p>
you get pras number : -1( if your Prize =-1 , you dont get Prize)<p>
-1<p>
{2,3,5,6,11,15,16,22,24,27,30,|7}<p>

price 1339.8<p>
11<p>
{Empty}<p>
{Empty}<p>
{2,3,6,10,29,30,|4}<p>
{2,3,5,6,24,36,|4}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
<p>
5.8<p>
{2,3,6,10,29,30,|4}<p>
{2,3,5,6,24,36,|4}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
<p>
{Empty}<p>
{Empty}<p>
{2,3,4,10,13,17,19,28,|2}<p>
{Empty}<p>
{Empty}<p>
{3,6,8,16,23,25,28,31,|7}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
<p>
162.4<p>
{2,3,4,10,13,17,19,28,|2}<p>
{3,6,8,16,23,25,28,31,|7}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
{Empty}<p>
<p>
 */

public class Demo {

	public static void main(String[] args) {
		try{
			char letter = 'a';
			System.out.println(letter++);

			System.out.println(letter++);

			System.out.println(letter++);

			System.out.println(letter++);
			
			
			Table t=new Table();
			Table t3=new Table();
			t3.setNumber(3);
			t3.setNumber(6);
			t3.setNumber(7);
			t3.setNumber(11);
			t3.setNumber(17);
			t3.setNumber(5);
			
			t3.setStrongNumber(1);
			t3.completeUnsigned();
			System.out.println(t3);
			
			System.out.println("price "+ t3.tablePrice());
			System.out.println(t3.winningCategory(t3));
			
			
			Xtable t1=new Xtable(11);
			t1.setNumber(3);
			t1.setNumber(5);
			t1.setNumber(6);
			t1.setNumber(2);
			t1.setNumber(15);
			t1.setNumber(22);
	
			t1.completeUnsigned();
			System.out.println(t1);
			System.out.println("price "+t1.tablePrice());
			
			System.out.println(t1.nSigned());
		
			
			Loto l=new Loto();
			l.tables[2].setNumber(2);
			l.tables[2].setNumber(3);
			l.tables[2].setNumber(6);
			
			l.tables[3].setNumber(2);
			l.tables[3].setNumber(3);
			l.tables[3].setNumber(6);
			
		
			l.completePartialTables();
			System.out.println(l);
			System.out.println(l.calcLottoForm());
			l.orderTables();
			System.out.println(l);
			
			
			
		

			Xloto s= new Xloto(8);
			s.xtables[5].setNumber(3);
			s.xtables[2].setNumber(4);
			s.xtables[5].setNumber(8);
			s.CompleteTable();
			
			System.out.println(s);
			System.out.println(s.calcLottoForm());
			s.orderTables();
			System.out.println(s);
			
		}
		catch(Exception e){
			System.out.println("caught Exception ");
		e.printStackTrace();
		
		}
	}
}
