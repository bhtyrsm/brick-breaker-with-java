


public class Counter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	int  NumberOfBrick=32;
	
	
	public int getNumberOfBrick() {
		return NumberOfBrick;
	}

	public void setNumberOfBrick(int numberOfBrick) {
		NumberOfBrick = numberOfBrick;
	}
	
	
	
	public int getNum()
	{
		return NumberOfBrick;
	}
	public void decrement()
	{
		this.NumberOfBrick--;
	}

	public void ShowNum()
	{
		System.out.println("LEFT BOX :"+Integer.toString(NumberOfBrick));
	}
	
}
