//°¸Àý£º´Ó¼üÅÌÊäÈëÉúÈÕ£¬ÅÐ¶ÏÐÇ×ù
class Day03_Test04{
	public static void main(String[] args){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("ÔÂ£º");
		int month = input.nextInt();
		
		System.out.print("ÈÕ£º");
		int day = input.nextInt();
		
		//(1)Ë®Æ¿×ù
		if(month==1 && day>=20 || month==2 && day<=18){
			System.out.println("Ë®Æ¿×ù");
		}else if(month==2 && day>=19 || month==3 && day<=20){
			System.out.println("Ë«Óã×ù");
		}else if(month==3 && day>=21 || month==4 && day<=19){
			System.out.println("°×Ñò×ù");
		}else if(month==4 && day>=20 || month==5 && day<=20){
			System.out.println("½ðÅ£×ù");
		}else if(month==5 && day>=21 || month==6 && day<=21){
			System.out.println("Ë«×Ó×ù");
		}else if(month==6 && day>=22 || month==7 && day<=22){
			System.out.println("¾ÞÐ·×ù");
		}else if(month==7 && day>=23 || month==8 && day<=22){
			System.out.println("Ê¨×Ó×ù");
		}else if(month==8 && day>=23 || month==9 && day<=22){
			System.out.println("´¦Å®×ù");
		}else if(month==9 && day>=23 || month==10 && day<=22){
			System.out.println("ÌìÆ½×ù");
		}else if(month==10 && day>=24 || month==11 && day<=22){
			System.out.println("ÌìÐ«×ù");
		}else if(month==11 && day>=23 || month==12 && day<=21){
			System.out.println("ÉäÊÖ×ù");
		}else if(month==12 && day>=22 || month==1 && day<=19){
			System.out.println("Ä¦ôÉ×ù");
		}
	}
}