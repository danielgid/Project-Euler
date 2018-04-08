
public class PrimesNum {
	private int num;
	private int steps;
	
	public PrimesNum(int num){
		this.num=num;
		this.steps=0;
	}
	
	public void setSteps(int steps){
		this.steps=steps;
	}
	
	public int getValue(){
		return this.num;
	}
	
	public int getSteps(){
		return this.steps;
	}
	
}
