package io.code;

//Computing composition values of protein for four attributes
//Each protein will have twelve composition values, three for each attribute
public class Composition {
	
	//Maps object
	private Maps maps;
	
	//Keeping track of number of residues in each group
	int[][] theOldCounts = new int [4][3];
	
	//Storing percentage wise composition of each group
	float[][] thecounts = new float [4][3];
	
	public Composition(Maps maps) {
		this.maps=maps;
		this.getCounts();
	}
	
	//return Map object, used in Distribution class
	public Maps getMaps() {
		return maps;
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
	
	//Gets the composition values
	public void getCounts() 
	{
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 3; j++)
				thecounts[i][j] = 0;
		
		//Keeping track of integer Count value
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 3; j++)
				theOldCounts[i][j] = 0;


		for(int i = 0; i <maps.length; i++) {
			if(maps.Array1.charAt(i) == 'H')
				thecounts[0][0]++;
			else if(maps.Array1.charAt(i) == 'E') 
				thecounts[0][1]++;
			else
				thecounts[0][2]++;
			if(maps.Array2.charAt(i) == 'H')
				thecounts[1][0]++;
			else if(maps.Array2.charAt(i) == 'E') 
				thecounts[1][1]++;
			else
				thecounts[1][2]++;
			if(maps.Array3.charAt(i) == 'H')
				thecounts[2][0]++;
			else if(maps.Array3.charAt(i) == 'E') 
				thecounts[2][1]++;
			else
				thecounts[2][2]++;
			if(maps.Array4.charAt(i) == 'H')
				thecounts[3][0]++;
			else if(maps.Array4.charAt(i) == 'E') 
				thecounts[3][1]++;
			else
				thecounts[3][2]++;
		}
		
		//Getting composition value between 1 and 0
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				theOldCounts[i][j]=(int) thecounts[i][j];
				thecounts[i][j]/=maps.length;
			}
		}
		
		//Displaying the obtained values
		System.out.println("\nCOMPOSITION");
		System.out.println("HYDROPHOBICITY: H: " + thecounts[0][0] + " E: " + thecounts[0][1] + " -: " + thecounts[0][2]);
		System.out.println("POLARIZABILITY: H: " + thecounts[1][0] + " E: " + thecounts[1][1] + " -: " + thecounts[1][2]);
		System.out.println("POLARITY: H: " + thecounts[2][0] + " E: " + thecounts[2][1] + " -: " + thecounts[2][2]);
		System.out.println("VAN DER WALLS VOLUME: H: " + thecounts[3][0] + " E: " + thecounts[3][1] + " -: " + thecounts[3][2]);
	}
}
