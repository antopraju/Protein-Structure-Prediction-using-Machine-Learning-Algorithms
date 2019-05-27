package io.code;


//Computing amino acid composition values of protein
//Each protein will have twenty composition values
public class PercentFrequency {

	//Maps object
	private Maps maps;
	
	//Storing residue wise composition in protein
	float[] thecounts = new float[20];
	
	public PercentFrequency(Maps maps) {
		this.maps=maps;
		this.getCounts();
	}
	
	//Returns One dimensional array to VectorForm class
	public float[] getVector() {
		return thecounts;
	}
	
	//Get amino acid composition
	public void getCounts() {
		
		for(int i=0;i<20;i++)
				thecounts[i]=0;
		
		for(int i=0;i<maps.length;i++) {
			char ch=maps.protein.charAt(i);
			if(ch=='R')
				thecounts[0]++;
			if(ch=='K')
				thecounts[1]++;
			if(ch=='E')
				thecounts[2]++;
			if(ch=='D')
				thecounts[3]++;
			if(ch=='Q')
				thecounts[4]++;
			if(ch=='N')
				thecounts[5]++;
			if(ch=='G')
				thecounts[6]++;
			if(ch=='A')
				thecounts[7]++;
			if(ch=='S')
				thecounts[8]++;
			if(ch=='T')
				thecounts[9]++;
			if(ch=='P')
				thecounts[10]++;
			if(ch=='H')
				thecounts[11]++;
			if(ch=='Y')
				thecounts[12]++;
			if(ch=='C')
				thecounts[13]++;
			if(ch=='V')
				thecounts[14]++;
			if(ch=='L')
				thecounts[15]++;
			if(ch=='I')
				thecounts[16]++;
			if(ch=='M')
				thecounts[17]++;
			if(ch=='F')
				thecounts[18]++;
			if(ch=='W')
				thecounts[19]++;
		}
		
		//Getting percentage values of amino acid composition
		for(int i=0;i<20;i++)
			thecounts[i]/=maps.length;
		
		//Displaying percentage frequency of each amino acid
		System.out.println("\nAMINO ACID COMPOSTION");
		System.out.println("R:"+thecounts[0]+" K:"+thecounts[1]+" E: "+thecounts[2]+" D: "+thecounts[3]);
		System.out.println("Q:"+thecounts[4]+" N:"+thecounts[5]+" G: "+thecounts[6]+" A: "+thecounts[7]);
		System.out.println("S:"+thecounts[8]+" T:"+thecounts[9]+" P: "+thecounts[10]+" H: "+thecounts[11]);
		System.out.println("Y:"+thecounts[12]+" C:"+thecounts[13]+" V: "+thecounts[14]+" L: "+thecounts[15]);
		System.out.println("I:"+thecounts[16]+" M:"+thecounts[17]+" F: "+thecounts[18]+" W: "+thecounts[19]);
	}
}
