package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lumberjack {
	private Integer size;
	private Integer logs;
	private Integer[][] area;
	
	public Lumberjack(String file) throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line = br.readLine();
	        
	        
	        int count=1;
	        int i=0;
	        int j=0;
	        
	        while (line != null) {
	        	if(count==1){
	        		this.size = Integer.valueOf(line.toString());
	        		this.area = new Integer[this.size][this.size];
	        	}else if(count==2){
	        		this.logs = Integer.valueOf(line.toString());
	        	}else{
	        		String[] parts ; //= line.split("[0-9 ]+");
	        		parts = line.trim().split(" +");
	        		if(i<this.size){
	        			
		        		for(String s : parts){
		        			//System.out.print(s);
		        			try{
		        			area[i][j] = Integer.valueOf(s.toString());
		        			}catch(Exception e){
		        				
		        			}
		        			j++;
		        		}
		        		i++;
			            j=0;
	        		}
	        	}
	            line = br.readLine();
	            count++;
	        }
	    }
	}
	
	public Integer[][] minimumValuePosition(){
		Integer[][] res = new Integer[1][2];
		res[0][0] = 0;
		res[0][1] = 0;
		
		if(this.area != null){
			int min = this.area[0][0];
			for(int i=0; i< this.size; i++){
				for(int j=0; j<this.size; j++){
					if(this.area[i][j]<min){min = this.area[i][j]; res[0][0]=i; res[0][1]=j;}
				}
			}
		}
		
		
		return res;
	}
	
	public void solve(){
		if(this.logs>0){
			Integer[][] pos;
			int value;
			for(int l=this.logs; 0<l;l=this.logs){
				//System.out.println(l);
				pos = minimumValuePosition();
				value = this.area[pos[0][0]][pos[0][1]];
				if(this.logs>0){
					for(int i=pos[0][0]; i<this.size; i++){
						for(int j=pos[0][1]; j<this.size;j++){
							if(this.logs>0 && this.area[i][j]==value){
								this.area[i][j]++;
								this.logs--;
							}
						}
					}
				}
			}
			
		}
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
			s.append("Size: "+this.size+"\n");
			s.append("Logs: "+this.logs+"\n");
			for(int i=0; i< this.size;i++){
				for(int j=0;j<this.size;j++){
					s.append(this.area[i][j]+" ");
				}
				s.append("\n");
			}
		
		return s.toString();
	}
	
}
