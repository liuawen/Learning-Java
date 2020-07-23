class Test11{
	public static void main(String[] args){
		int i = 1;
		int j = 5;
		j *= i++ + j++;
		System.out.println(i);
		System.out.println(j);
	}
}