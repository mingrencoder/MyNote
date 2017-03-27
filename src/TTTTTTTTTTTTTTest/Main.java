package TTTTTTTTTTTTTTest;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String s = in.nextLine();
			System.out.println(getMax(s));
		}
	}

	static int getMax(String s){  
        int n=s.length();  
        if(s==null||s==""){  
            return 0;  
        }
        if(s.length()==1){
        	return 1;
        }
        String max=s.substring(0, 1);  
        for(int i=0; i<n-1; i++){  
            String p1=getString(s,i,i);  
            if(p1.length()>max.length()){  
            	max=p1;  
            }  
            String p2=getString(s,i,i+1);  
            if(p2.length()>max.length()){  
            	max=p2;  
            }  
        }  
        if(max.length()%2==0){
        	return (max.length())/2; 
        } else {
        	return (max.length()-1)/2; 
        } 
    }  
      
    static String getString(String s,int m1,int m2){  
        int n=s.length();       
        while(m1>=0 && m2<=n-1 && s.charAt(m1)==s.charAt(m2)){  
            m1--;  
            m2++;  
        }
        return s.substring(m1+1, m2);         
    }
}
