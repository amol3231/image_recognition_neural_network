class MatMult
{
	public static void main(String a[])
	{
		int mat1[][]=new int[2][3];
		int mat2[][]=new int[3][2];
		
		int mat3[][]=new int[2][4];
		
		for(int i=0;i<mat1.length;i++)
		{
		    for(int k=0;k<mat1[0].length;k++)
		    {
			   mat1[i][k]=(i+1)*k;
			   System.out.print(mat1[i][k] +" ");			   
		    }System.out.println();		
		}
		
		for(int i=0;i<mat1[0].length;i++)
		{
		    for(int k=0;k<mat1.length;k++)
		    {
			   mat2[i][k]=mat1[k][i];
			   System.out.print(mat2[i][k] +" ");
			   
		    }		
			System.out.println();
		}
	}
}
