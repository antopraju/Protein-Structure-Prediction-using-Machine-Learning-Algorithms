package io.code;

//Computing transition values of protein for four attributes
//Each protein will have twelve transition values, three for each attribute
public class Transition {

	//Maps object
	private Maps maps;
	
	//Keep track of transition values for each attribute
	//Each row for an attribute, columns denote transition values for each group
	float[][] thecounts = new float [4][3];
	
	public Transition(Maps maps) {
		this.maps=maps;
		this.getCounts();
	}
	
	//Return one dimensional array to VectorForm Class
	public float[] getVector() {
		
		float array[]=new float[12];
		int index=-1;
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				++index;
				array[index]=thecounts[i][j]; 
			}
		}
		return array;
	}

	//Gets the transition values
	public void getCounts() {	
		
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 3; j++)
				thecounts[i][j] = 0;
		
		for(int i=0;i<maps.length-1;i++) {
			if(maps.Array1.charAt(i) == 'H' && maps.Array1.charAt(i+1) == 'E')
				thecounts[0][0]++;
			else if(maps.Array1.charAt(i) == 'E' && maps.Array1.charAt(i+1) =='-') 
				thecounts[0][1]++;
			else if(maps.Array1.charAt(i) == '-' && maps.Array1.charAt(i+1) == 'H')
				thecounts[0][2]++;
			if(maps.Array2.charAt(i) == 'H' && maps.Array2.charAt(i+1) == 'E')
				thecounts[1][0]++;
			else if(maps.Array2.charAt(i) == 'E' && maps.Array2.charAt(i+1) == '-') 
				thecounts[1][1]++;
			else if(maps.Array2.charAt(i) == '-' && maps.Array2.charAt(i+1) == 'H')
				thecounts[1][2]++;
			if(maps.Array3.charAt(i) == 'H' && maps.Array3.charAt(i+1) == 'E')
				thecounts[2][0]++;
			else if(maps.Array3.charAt(i) == 'E' && maps.Array3.charAt(i+1) == '-') 
				thecounts[2][1]++;
			else if(maps.Array3.charAt(i) == '-' && maps.Array3.charAt(i+1) == 'H')
				thecounts[2][2]++;
			if(maps.Array4.charAt(i) == 'H' && maps.Array4.charAt(i+1) == 'E')
				thecounts[3][0]++;
			else if(maps.Array4.charAt(i) == 'E'&&maps.Array4.charAt(i+1) == '-') 
				thecounts[3][1]++;
			else if(maps.Array4.charAt(i) == '-' && maps.Array1.charAt(i+1) == 'H')
				thecounts[3][2]++;
		}
		
		//Getting transition value between 1 and 0
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				thecounts[i][j]/=maps.length;
			}
		}
		
		//Displaying the obtained values
		System.out.println("\nTRANSITION");
		System.out.println("HYDROPHOBICITY: 1->2: " + thecounts[0][0] + " 2->3: " + thecounts[0][1] + " 3->1: " + thecounts[0][2]);
		System.out.println("POLARIZABILITY: 1->2: " + thecounts[1][0] + " 2->3: " + thecounts[1][1] + " 3-1: " + thecounts[1][2]);
		System.out.println("POLARITY: 1->2: " + thecounts[2][0] + " 2->3: " + thecounts[2][1] + " 3->1: " + thecounts[2][2]);
		System.out.println("VAN DER WALLS VOLUME: 1->2: " + thecounts[3][0] + " 2->3: " + thecounts[3][1] + " 3->1: " + thecounts[3][2]);
		
	}
}
