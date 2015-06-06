package main;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Lumberjack a = new Lumberjack(args[0]);
		//System.out.println(a.toString());
		
		/*for(Integer[] i : a.minimumValuePosition()){
			for(Integer l: i){
				System.out.println(l+" ");
			}
		}*/
		
		a.solve();
		System.out.println(a.toString());
		
	}

}
