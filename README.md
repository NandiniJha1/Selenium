// Grid Problem 

package SoftTech;
import java.util.Scanner;

public class GridSolution {

	static int M,N,Answer,StartRow,StartCol,DisRow,DisCol,front,rear;
	static int grid[][]=new int[3000][3000];
	static int visited[][]=new int[3000][3000];
	static int queueX[]=new int[3000];
	static int queueY[]=new int[3000];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
       
        int T=sc.nextInt();
        for(int i=0;i<T;i++)
        {
        M=sc.nextInt();
        N=sc.nextInt();
        StartRow=sc.nextInt();
        StartCol=sc.nextInt();
        for(int j=1;j<=M;j++)
        {
        	for(int k=1;k<=N;k++)
        	{
        		grid[j][k]=sc.nextInt();
        		if(grid[j][k]==2)
        		{
        			DisRow=j;
        			DisCol=k;
        		}
        	}
        }
        Answer=0;
        front=rear=0;
        reset();
        enque(StartRow,StartCol);
        visited[StartRow][StartCol]=1;
        BFS();
        /*for(int j=1;j<=M;j++)
        {
        	for(int k=1;k<=N;k++)
        	{
        		System.out.print(visited[j][k]+" ");
        	}
        	System.out.println("");
        }*/
        	
        if(Answer==0)
        {
        	System.out.println("Case" +"#"+T+" ");
        	System.out.println(-1+" "+ -1+" ");
        }
        else
        {
        	boolean check=true;
        	int maxCount=0;
        	int maxOther=0;
        	outerloop:
        	for(int k=1;k<=M;k++)
        	{
        		for(int j=1;j<=N;j++)
        		{
        			if(visited[k][j]==0 && grid[k][j]!=0)
        			{
        				check=false;
        				break outerloop;
        			}
        			if(visited[k][j]>maxCount && grid[k][j]==2)
        				maxCount=visited[k][j];
        			if(visited[k][j]>maxOther && grid[k][j]==1)
        				maxOther=visited[k][j];
        		}
        	}
        	if(check==false) {
        		System.out.println("Case" +" "+"#"+" "+T+" ");
            	System.out.println(-1+" "+ -1+" ");
        	}
        	else if(check==true && maxOther>0 && maxCount>0) {
        		System.out.println("Case" +" "+"#"+" "+T+" ");
            	System.out.println(maxCount+" "+ maxOther+" ");
        	}
        }
        }
        sc.close();
	}

	private static void enque(int startRow2, int startCol2) {
		// TODO Auto-generated method stub
		queueX[rear]=startRow2;
		queueY[rear++]=startCol2;
		
	}

	private static void BFS() {
		// TODO Auto-generated method stub
		int[] dRow= {0,0,-1,1};
		int[] dCol= {-1,1,0,0};
		while(front!=rear)
		{
			 int tRow=queueX[front];
			 int tCol=queueY[front++];
			 for(int i=0;i<4;i++)
			 {
				 int tempRow=tRow+dRow[i];
				 int tempCol=tCol+dCol[i];
				 if(tempRow>=0 && tempRow<=M &&tempCol>=0 && tempCol<=N && visited[tempRow][tempCol]==0 )
				 {
					if(grid[tempRow][tempCol]==1)
					{
					  visited[tempRow][tempCol]	=visited[tRow][tCol]+1;
					 // System.out.println(visited[tempRow][tempCol]); 
					  enque(tempRow,tempCol);
					  Answer=1;
					}
					if(grid[tempRow][tempCol]==2)
					{
						if(tempRow-1>=0 && tempRow+1<=M && tempCol-1>=0 && tempCol+1<=N && visited[tempRow+1][tempCol]>0 && visited[tempRow-1][tempCol]>0 && visited[tempRow][tempCol-1]>0 && visited[tempRow][tempCol+1]>0)
					  {
							visited[tempRow][tempCol]=visited[tRow][tCol];     
					  }
					}
				 }
			 }
		}
		
	}

	private static void reset() {
		// TODO Auto-generated method stub
		for(int j=1;j<=M;j++)
        {
        	for(int k=1;k<=N;k++)
        	{
        		visited[j][k]=0;
        	}
        }
	}

}
