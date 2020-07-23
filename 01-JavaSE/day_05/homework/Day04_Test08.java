class Day04_Test08{
	public static void main(String[] args){
		for(int i=1; i<=7; i++){//控制行数
			//(1)打印该行的*或o
			/*
			发现O+*的总个数是7个
			当i=1, 当j=1和j=7的时候是O，其余的是* 
			当i=2, 当j=2和j=6的时候是O，其余的是* 
			当i=3, 当j=3和j=5的时候是O，其余的是* 
			当i=4, 当j=4的时候是O，其余的是* 
			当i=5, 当j=5和j=3的时候是O，其余的是* 
			当i=6, 当j=6和j=2的时候是O，其余的是* 
			当i=7, 当j=7和j=1的时候是O，其余的是* 
			*/
			for(int j=1; j<=7; j++){
				if(i==j || i==8-j){
					System.out.print("O");
				}else{
					System.out.print("*");
				}
			}
			
			//(2)每一行的最后一件事是换行
			System.out.println();
		}
	}
}