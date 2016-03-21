import java.io.BufferedReader;
import java.io.FileReader;


public class sudoku {
	
	//private int[][] arr = new int[9][9];
		public static int[][] readFile(String filename,int p)
		{
			int[][] arr = new int[9][9];
			try
			{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			int count = -1;
			for(int k=1;k<p;k++)
			{
				reader.readLine();
			}
		    while ((line = reader.readLine()) != null && count <9 )
		    {
		    	//System.out.println(line+ " " +count);
		    	if(count==-1)
		    		{count++;continue;}
		    	else
		    	{
		    		for(int i = 0;i<9;i++)
		    		{
		    			arr[count][i] = Character.getNumericValue(line.charAt(i));
		    		}
		    	}
		    	count++;
		    }
		    reader.close();
		    return arr;
		  }
		  catch (Exception e)
		  {
			 // System.err.format("Exception occurred trying to read '%s'.", filename);
			  e.printStackTrace();
		    return null;
		  }
		}
		
		// solving sudoku and returning sum of first three digits
		public static boolean isvalid(int[][] A, int val,int row ,int col)
	    {
	        for(int i= 0 ; i< 9; i++)
	            {
	                int c = A[row][i];
	                if(c==0) continue;
	                if( c == val)
	                    {
	                        return false;
	                    }
	                
	            }
	            
	        for(int i = 0; i<9 ;i++)
	            {
	                 int c = A[i][col];
	                if(c==0) continue;
	                if(c == val)
	                    {
	                        return false;
	                    }
	            }
	            
	        int s1=-1,s2=-1,n1=-1,n2=-1;
	        if(row<=2 && col<=2)
	        {
	          n1 = 2;
	          n2 = 2;
	          s1 = 0;
	          s2 = 0;
	        }
	        
	        else if(row<=2 && col >2 && col <=5)
	        {
	            n1 = 2;
	            n2 = 5;
	            s1 = 0;
	            s2 = 3;
	            
	        }
	        
	        else if(row<=2 && col >5 && col <=8)
	        {
	            n1 = 2;
	            n2 = 8;
	            s1 = 0;
	            s2 = 6;
	            
	        }
	        
	        else if(row>2 && row<=5  && col >2 && col <=5)
	        {
	            n1 = 5;
	            n2 = 5;
	            s1 = 3;
	            s2 = 3;
	            
	        }
	        
	        
	         else if(row>2 && row<=5   && col <=2)
	        {
	            n1 = 5;
	            n2 = 2;
	            s1 = 3;
	            s2 = 0;
	            
	        }
	        
	         else if(row>2 && row<=5  && col >5 && col <=8)
	        {
	            n1 = 5;
	            n2 = 8;
	            s1 = 3;
	            s2 = 6;
	            
	        }
	        
	         else if(row>5 && row<=8  && col >5 && col <=8)
	        {
	            n1 = 8;
	            n2 = 8;
	            s1 = 6;
	            s2 = 6;
	            
	        }
	        
	         else if(row>5 && row<=8  && col <=2)
	        {
	            n1 = 8;
	            n2 = 2;
	            s1 = 6;
	            s2 = 0;
	            
	        }
	        
	         else if(row>5 && row<=8  && col >2 && col <=5)
	        {
	            n1 = 8;
	            n2 = 5;
	            s1 = 6;
	            s2 = 3;
	            
	        }
	        
	            for(int i = s1;i<=n1;i++)
	                {
	                    for(int j =s2;j<=n2;j++)
	                        {
	                            int c = A[i][j];
	                             if(c==0) continue;
	                                if(c == val)
	                                    {
	                                        return false;
	                                    }
	                        }
	                }
	              return true;
	        }
	        
	public static boolean solve(int[][] A)
	{
	    int i=0,j=0;  
	    
	    outerloop:
	    for( i =0; i<9;i++)
        {
            for(j = 0; j<9;j++)
                {
                    if(A[i][j]==0)
                        break outerloop;
                }
        }
	    
	 // checking whether sudoku is already filled
	    if(i==9 && j==9)
	        return true;

        for(int k=1; k<=9; k++)
            {
                if(isvalid(A,k,i,j))
                    {
                        A[i][j] = k;
                         if(solve(A))
                            return true;
                        A[i][j] =0;
                    }
            }

	                
	            
	        
	    return false;
	}
			

		public static void main(String[] args)
		{
			
			for(int k =0;k<50;k++)
			{
				 int[][] arr = readFile("C:\\p096_sudoku.txt",k*10+1);
				
				 System.out.print("Grid "+(k+1) +" : ");
				 solve(arr);
				/* for(int i=0;i<9;i++)
				 {
					 for(int j=0;j<9;j++)
						 System.out.print(arr[i][j]);
					 System.out.println();
				 }*/
					System.out.print(arr[0][0]+arr[0][1]+arr[0][2]);
				 System.out.println();
			}
			 
		}
}
