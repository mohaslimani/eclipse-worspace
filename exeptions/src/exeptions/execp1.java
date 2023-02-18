package exeptions;

public class execp1 {

	public static void main(String[] args) {
		double tst[] = new double [3];
		tst[0] = 1;
		tst[1] = 2;
		tst[2] = 3;
		//tst[3] = 4; this line will throw this Exception
		//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		//at exeptions/exeptions.execp1.main(execp1.java:10)
		//nice in not printed
		try {
			//tst[3] = 4;
			f (0);
			//throw new Exception ("throw works here");
		//} catch (ArrayIndexOutOfBoundsException x) {
			//System.out.println("an ArrayIndexOutOfBoundsException E is catched");
			//System.err.println(x.getMessage());
			//nice is printed
		} catch (Exception e) {
			System.out.println("an Exception E is catched");
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			//nice is printed
		}
		
		System.out.println("nicee ");
	}
	
	public static void f(int i) throws Exception
	{
		if (i == 0) 
		{
			throw new Exception("emmmm");
		}
	}

}
