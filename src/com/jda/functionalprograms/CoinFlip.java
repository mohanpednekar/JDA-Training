/**********************************************
 * 
 * Purpose: Filp a coin and find percentage of Heads and Tails
 * 
 * @author Mohan Pednekar
 * @version 1.0
 * @since 04-07-2018
 * 
 */



package com.jda.functionalprograms;

enum CoinFace{
	HEAD(0),TAIL(0);
	
	private int count;
	
	private CoinFace(int n){
		count=n;
	}

	public CoinFace toss() {
		count++;		
		return this;
	}
	
	public int frequency(){
		return count;
	}
}
