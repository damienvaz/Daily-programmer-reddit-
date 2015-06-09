package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.math.BigInteger;

public class Palindromic {
	private int[] res;
	private int[] number;
	private int steps;
	
	public Palindromic(String file) throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line = br.readLine();
	        
	        while (line != null) {
	        	this.res = this.number = arrayString2arrayInt(line.trim().split("|"));
	        	this.steps = 0;
	        	solve(this.number);
	        	
	            line = br.readLine();
	           
	        }
	    }
	}
	
	public boolean isPalindromic(int[] a){
		boolean res = true;
		int count = 0;
		
		if(a.length%2 == 0){
			for(int i=0; i<(a.length/2); i++){
				if(a[i] != a[a.length-1-i]){ res = false;}
			}
		}else{
			for(int i=0; i<((a.length-1)/2); i++){
				if(a[i] != a[a.length-1-i]){ res = false;}
			}
		}
		
		
		return res;
	}

	private int[] arrayString2arrayInt(String[] s){
		int[] res= new int[s.length];
		int i=0;
		
		for(String l : s){
			res[i] = Integer.parseInt(l);
			i++;
		}
		
		return res;
	}
	
	private int[] string2arrayInt(String s){
		String[] parts = s.trim().split("|");
		int[] i = new int[parts.length];
		int j=0;
		
		for(String c : parts){
			i[j] = Integer.valueOf(c);
			j++;
		}
		
		return i;
	}
	
	private String arrayInt2String(int[] i){
		String s = "";
		
		for(int j : i){
			s+=j;
		}
		
		return s;
	}
	
	private int[] calculate(int[] i1, int[] i2){
		int[] res = new int[i1.length+1];
		int rest = 0;
		int add;
		
		for(int i=i1.length-1; i>=0;i--){
			add = i1[i]+i2[i]+rest;
			if((add/10) >= 1){	res[i+1] = (add%10); rest = (add/10);	}
			else{
				res[i+1] = add; rest=0;
				
			}
		}
		
		res[0] = rest;
		
		if(res[0] == 0){
			int[] res2 = new int[res.length-1];
			
			for(int i=1; i<res.length;i++){
				res2[i-1]= res[i];
			}
			res = res2;
		}
		
		return res;
	}
	
	private int[] reverseArrayInt(int[] i){
		int[] res = new int[i.length];
		int l=0;
		
		for(int j = i.length-1; j>=0; j--){
			res[l] = i[j];
			l++;
		}
		return res;
	}
	
	public void solve(int[] i){
    	int[] i1;
    	int[] i2;
    	int count = 0;
		while(!isPalindromic(this.res)){
			
    		i1 = this.res;
			i2 = reverseArrayInt(i1);
			this.res = calculate(i1, i2);
			this.steps++;
			count++;
		}
		System.out.println(toString());
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
			s.append(arrayInt2String(this.number)+" gets palindromic after "+this.steps+" steps: "+arrayInt2String(this.res));
		return s.toString();
	}
}
