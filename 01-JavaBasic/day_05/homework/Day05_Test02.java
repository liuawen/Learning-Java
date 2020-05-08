class Day05_Test02{
	public static void main(String[] args){
		String[] hua = {"ºÚÌÒ","ºìÌÒ","Ã·»¨","·½Æ¬"};
		String[] dian = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		
		for(int i=0; i<hua.length; i++){
			for(int j=0; j<dian.length; j++){
				System.out.print(hua[i]+dian[j] + " ");
			}
			System.out.println();
		}
	}
}