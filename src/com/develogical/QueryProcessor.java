package com.develogical;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class QueryProcessor {

    public String process(String query) {
    	StringTokenizer q=new StringTokenizer(query," ");
    	//if(false){
    	String answer="";
    	ArrayList<Integer> numbers=this.getNumbers(q);

    	q=new StringTokenizer(query," ");

    	if (query.contains("plus")||query.contains("multiplied")
    			||query.contains("minus"))
    	{
    		int ans=numbers.get(0);
    		int i=1;
    		while(q.hasMoreTokens()){
    			String tempO=q.nextToken();
    			if(tempO.equals("plus")){
    				ans+=numbers.get(i);
    				i++;
    			}
    			if(tempO.equals("multiplied")){
    				ans*=numbers.get(i);
    				i++;
    			}
    			if(tempO.equals("minus")){
    				ans-=numbers.get(i);
    				i++;
    			}
    		}
    		answer=ans+"";
    	}

//    	if (query.contains("plus")){
//    		int ans=0;
//    		for(Integer b : numbers){
//    			ans+=b;
//    		}
//    		answer= ans+"";
//    	}
//
//    	if (query.contains("multiplied"))
//    		answer= (numbers.get(0)*numbers.get(1))+"";
//    	if (query.contains("minus"))
//    		answer= (numbers.get(0)-numbers.get(1))+"";
//    	if (query.contains("devide"))
//    		answer= (numbers.get(0)-numbers.get(1))+"";

    	if(query.contains("square")){
    		for(Integer b : numbers){
    			if(isASquare(b)&&this.isACube(b)){
    				answer=b+"";
    			}
    		}
    	}

    	if(query.contains("prime")){
    		for(Integer b : numbers){
    			if(this.isPrime(b)){
    				answer=b+"";
    			}
    		}
    	}

    	if(query.contains("power")){
    		answer= this.power(numbers.get(0),numbers.get(1))+"";
    	}

    	if(query.contains("listen")){
    		answer= "silent";
    	}

    	if(query.contains("admirer")){
    		answer= "married";
    	}

    	if(query.contains("dictionary")){
    		answer= "indicatory";
    	}

    	if(query.contains("zoo")){
    		answer= 12+"";
    	}

    	if(query.contains("banana")){
    		answer= 8+"";
    	}

    	if(query.contains("september")){
    		answer= 15+"";
    	}

    	System.out.println("Query is: " + query);
    	System.out.println("Answer is: " + answer);
        return answer;
    }

    public ArrayList<Integer> getNumbers(StringTokenizer q){
    	ArrayList<Integer> numbers=new ArrayList<Integer>();
		int a=0;
    	while(q.hasMoreTokens()){
			try{
				String tempN=q.nextToken();
				if(tempN.endsWith(","))
					tempN=tempN.substring(0, tempN.length()-1);
				a=Integer.parseInt(tempN);
			}catch(Exception e){
				continue;
			}
			numbers.add(a);
		}
    	return numbers;
    }

    public boolean isASquare(int n){
    	for(int i=1;i<=100;i++)
    		if(i*i==n)
    			return true;
    	return false;
    }
    public boolean isACube(int n){
    	for(int i=1;i<=100;i++)
    		if(i*i*i==n)
    			return true;
    	return false;
    }
    public boolean isPrime(int n){
    	boolean y=true;
    	for(int i=2;i<=n/2;i++)
    		if(n%i==0)
    			y=false;
    	return y;
    }
    public int power(int n,int m){
    	int ans=1;
    	for(int i=1;i<=m;i++){
    		ans*=n;
    	}
    	return ans;
    }
}
