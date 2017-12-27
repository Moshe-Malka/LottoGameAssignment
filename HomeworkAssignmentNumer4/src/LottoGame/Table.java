package LottoGame;

import java.util.Random;
	/**
	* Table describes a table in a loto form - for Q1
	* <p>
	* The use of "protected" is in order to ease the code writing during the exam.
	* This way students did not need to put time and effort in getters and setters.
	* Obviously, in a real-system you should make class variables private. Use them in
	* inheriting classes through getter/setter methods.
	* @author dekel laifer id 203943436
	* moshe malka 
	* 
	*/
	public class Table{
		protected final int ORDINARY_NUMBERS_IN_TABLE = 37;
		protected final int SRTONG_NUMBERS_IN_TABLE = 7;
		protected int AMOUNT_OF_ORDINARY_NUMBERS = 6;
		protected final int MINIMAL_INDEX_IN_TABLE = 1;
		protected boolean[] numbers;
		protected boolean[] strongNumbers;

		public Table()
		{
			numbers = new boolean[ORDINARY_NUMBERS_IN_TABLE];
			// numbers[i]=false for i=0..36
			strongNumbers = new boolean[SRTONG_NUMBERS_IN_TABLE]; //strongNumbers[i]=false for i=0..6
			
		}

		public int N()
		{
			return AMOUNT_OF_ORDINARY_NUMBERS;
		}

		public void setNumber(int i)throws IllegalIndex, TooManyNumbers
		{
			if (i < MINIMAL_INDEX_IN_TABLE || i > ORDINARY_NUMBERS_IN_TABLE)
				throw new IllegalIndex();
			int n = nSigned();
			if (n == N() && numbers[i-1]==false)
				throw new TooManyNumbers();
			numbers[i-1] = true;
		}
		// **(1)** a method that calculates and returns the number of signed numbers in a table.
		public int nSigned() 
		{		
			int sumOfSignedNum=0;

			for (int i = 0; i < numbers.length; i++) 
			{
				if (numbers[i]==true)
				{
					sumOfSignedNum++;
				}
			}
			return sumOfSignedNum;
		}

		public void setStrongNumber(int i)throws IllegalIndex, TooManyNumbers
		{
			if (i < MINIMAL_INDEX_IN_TABLE || i > SRTONG_NUMBERS_IN_TABLE)
				throw new IllegalIndex(); 
			if (isStrongNumberSigned() && strongNumbers[i-1]==false)
				throw new TooManyNumbers();
			strongNumbers[i-1] = true;
		}
		// **(2)** a method that checks if a strong number is signed or not. returtn's false/true.
		private boolean isStrongNumberSigned() 
		{
			boolean checkStrong = false;
			for (int i = 0; i < strongNumbers.length; i++) 
			{
				if (strongNumbers[i]==true)
				{
					checkStrong=true;
				}
			}
			return checkStrong;
		}

		public void unsetNumber(int i) throws IllegalIndex
		{ 
			 if (i < MINIMAL_INDEX_IN_TABLE || i > ORDINARY_NUMBERS_IN_TABLE) 
			 throw new IllegalIndex(); 
			 numbers[i-1] = false; 
			 } 


		public void unsetStrongNumber(int i) throws IllegalIndex{ 
			 if (i < MINIMAL_INDEX_IN_TABLE || i > SRTONG_NUMBERS_IN_TABLE) 
			 throw new IllegalIndex(); 
			 strongNumbers[i-1] = false; 
			 } 


		// **(1)** a method that checks if any number/strong number is signed.
		public boolean checkIfEmpty()
		{
			boolean checkTable = false;
			if (nSigned() == 0 && isStrongNumberSigned() == false) 
			{
				checkTable = true;
			}
			return checkTable;
		}
		// **(4)** a method that check's if the table is full (6 numbers and 1 strong number). 
		public boolean isTableFull()
		{
			boolean checkFull = false;
			if (nSigned()==N() && isStrongNumberSigned()==true)
			{
				checkFull=true;
			}
			return checkFull;
		}

		//this method creates a "Normal" random number.
		public int createRandomNormalNum(int g)
		{
			Random rnd = new Random();
			int rand = 1+rnd.nextInt(g-1);
			return rand;
		}
		
		// **(5)** this method finish's an unsigned table. 
		// it uses 2 other method's to generate a random number:
		// "createRandomNormalNum" and "createRandomStrongNum",
		// and one method called "sSigned" to check if any Strong number is signed.
		public void completeUnsigned()
		{	
			
			while(sSigned()<MINIMAL_INDEX_IN_TABLE)
			{
					strongNumbers[createRandomNormalNum(SRTONG_NUMBERS_IN_TABLE)]=true;
			
			}
			while(nSigned()<N())
			{
				int a=(createRandomNormalNum(ORDINARY_NUMBERS_IN_TABLE));
				if(numbers[a]==false)
				{
					numbers[a]=true;
				}
				
					
			
			
			}
			
		}
		//***(Extra Method)*** returns the amount of signed strong numbers. 
		private int sSigned() 
		{
			int temp = 0;
			for (int i = 0; i < strongNumbers.length; i++) 
			{
				if (strongNumbers[i] == true)
					temp++;
			}
			return temp;
		}

		// ***(6)*** 
		public double tablePrice()
		{
			double tPrice = 0.0;
			if (isTableFull())
			{
				tPrice = 2.9;
			}

			return tPrice;
		}
		// ***(7)**** this method run's over the default toString method,
		// and sets a new print system for a Table.
		public String toString()
		{
			String tempString = "{";

			if (nSigned()==N() && sSigned()==1) 
			{
				for (int i = 0; i < numbers.length; i++) 
				{
					if (numbers[i]==true) 
					{
						tempString += (i+1)+",";	
					}
				}
				for (int k = 0; k < strongNumbers.length; k++) 
				{
					if (strongNumbers[k]==true) 
					{
						tempString += "|"+(k+1)+"";
					}
				}
				tempString += "}"+"\n";
			}

			if (nSigned()<N() && nSigned()>0)
			{
				tempString += "Incomplete}"+"\n";
			}

			if (nSigned()==0 && isStrongNumberSigned() == false) 
			{
				tempString += "Empty}"+"\n";
			}

			return tempString;
		}

		public int winningCategory(Table table){ 
			
			int Prize=-1;
			int k=0,l=0,s=0,q=0;
			Table t=new Table ();
			t.completeUnsigned();
			System.out.println(t);
			
			while(k<ORDINARY_NUMBERS_IN_TABLE){
				if(t.numbers[k]&&table.numbers[k]==true)
					s++;
			k++;
			}
			while(l<SRTONG_NUMBERS_IN_TABLE){
		
				if(t.strongNumbers[l]&&table.strongNumbers[l]==true)
					q++;		 
			l++;
			}
			
			if(s==5)
					if(q==1)
						Prize=3;
					else
						Prize=4;
			else if(s==6)
				   if(q==1)
					   Prize=1;
				 else Prize=2;
			System.out.println("you get pras number : " + Prize +"( if your Prize =-1 , you dont get Prize)"  );
			return Prize;
			
			
		}
}	

