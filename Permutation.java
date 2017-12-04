import java.util.*;
class Permutation
{
	static int count = 0;
	public String compute(int arr[],String s)
	{
		int len = arr.length;
		if(len == 1)
		{
			count++;
			System.out.print(s+arr[0]);
			System.out.println();
			return s.substring(0,s.length()-1);
		}
		for(int i=0; i<len; i++)
		{
			int remaining[] = new int[len-1];
			int k=0;
			for(int j=0; j<len; j++)
			{
				if(j!=i)
					remaining[k++] = arr[j];
				else
					s = s + Integer.toString(arr[j]);
			}
			s = compute(remaining,s);
		}
		if(s.length()-1 == -1)
			return ""; 
		return s.substring(0,s.length()-1);
	}
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number ");
		String str = scan.next();
		int len = str.length();
		int arr [] = new int[len];
		char a;
		for(int i=0; i<len; i++)
		{
			a = str.charAt(i);
			arr[i] = (int)a - 48;
		}
		String s = "";
		System.out.println("The possible solutions are :");
		Permutation obj = new Permutation();
		s = obj.compute(arr,s);
		System.out.println("Possible is = "+count);
	}
}
