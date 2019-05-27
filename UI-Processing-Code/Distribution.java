package io.code;

//Computing distribution values of protein for four attributes
//Each protein will have sixty distribution values, fifteen for each attribute
public class Distribution {
	
	//Composition object, Maps object already defined inside composition object
	private Composition comp;
	
	//Store the 0%,25%,50%,75%,100% values 
	int count[][]=new int[12][5];
	
	//End result of distribution
	float thecounts[][]=new float[4][15];
	
	public Distribution(Composition comp) {
		this.comp=comp;
		this.divide();
		this.getCountsArrayOne();
		this.getCountsArrayTwo();
		this.getCountsArrayThree();
		this.getCountsArrayFour();
		this.setFinal();
	}
	
	//Return one dimensional array to VectorForm Class
	public float[] getVector() {
		float array[]=new float[60];
		int index=-1;
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<15;j++) {
				++index;
				array[index]=thecounts[i][j]; 
			}
		}
		return array;
	}
	
	//Getting 0%,25%,50%,75%,100% positioning of residue in protein
	public void divide() {
		
		for(int i=0;i<12;i++) 
			for(int j=0;j<5;j++) 
				count[i][j]=0;
		
		for(int i=0;i<4;i++) 
			for(int j=0;j<15;j++) 
				thecounts[i][j]=0;
		
		int index=0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				int value=(int) comp.theOldCounts[i][j];
				count[index][0]=0;
				count[index][1]=(int) (value*0.25);
				count[index][2]=(int) (value*0.5);
				count[index][3]=(int) (value*0.75);
				count[index][4]=value;
				index++;
			}
		}
	}
	
	//Getting distribution values for attribute Hydrophobicity
	public void getCountsArrayOne() {
		
		int temp[]=new int[3];
		int index[]=new int[3];
		
		for(int i=0;i<comp.getMaps().length;i++) {
			
			char ch=comp.getMaps().Array1.charAt(i);
			
			if(ch=='H') {
				index[0]=i;
				temp[0]++;
			}
			
			else if(ch=='E') {
				index[1]=i;
				temp[1]++;
			}
			
			else {
				index[2]=i;
				temp[2]++;
			}
			
			if(temp[0]==count[0][1])
				thecounts[0][1]=i;
			
			else if(temp[0]==count[0][2])
				thecounts[0][2]=i;
			
			else if(temp[0]==count[0][3])
				thecounts[0][3]=i;
			
			if(temp[1]==count[1][1])
				thecounts[0][6]=i;
			
			else if(temp[1]==count[1][2])
				thecounts[0][7]=i;
			
			else if(temp[1]==count[1][3])
				thecounts[0][8]=i;
			
			if(temp[2]==count[2][1])
				thecounts[0][11]=i;	
			
			else if(temp[2]==count[2][2])
				thecounts[0][12]=i;
			
			else if(temp[2]==count[2][3])
				thecounts[0][13]=i;
		}	
		
		thecounts[0][4]=index[0];
		thecounts[0][9]=index[1];
		thecounts[0][14]=index[2];	
	}
	
	//Getting distribution values for attribute Polarizability
	public void getCountsArrayTwo() {
		
		int temp[]=new int[3];
		int index[]=new int[3];
		
		for(int i=0;i<comp.getMaps().length;i++) {
			
			char ch=comp.getMaps().Array2.charAt(i);
			
			if(ch=='H') {
				index[0]=i;
				temp[0]++;
			}
			
			else if(ch=='E') {
				index[1]=i;
				temp[1]++;
			}
			
			else {
				index[2]=i;
				temp[2]++;
			}
			
			if(temp[0]==count[3][1])
				thecounts[1][1]=i;
			
			else if(temp[0]==count[3][2])
				thecounts[1][2]=i;
			
			else if(temp[0]==count[3][3])
				thecounts[1][3]=i;
			
			if(temp[1]==count[4][1])
				thecounts[1][6]=i;
			
			else if(temp[1]==count[4][2])
				thecounts[1][7]=i;
			
			else if(temp[1]==count[4][3])
				thecounts[1][8]=i;
			
			if(temp[2]==count[5][1])
				thecounts[1][11]=i;	
			
			else if(temp[2]==count[5][2])
				thecounts[1][12]=i;
			
			else if(temp[2]==count[5][3])
				thecounts[1][13]=i;
		}
		
		thecounts[1][4]=index[0];
		thecounts[1][9]=index[1];
		thecounts[1][14]=index[2];	
	}

	//Getting distribution values for attribute Polarity
	public void getCountsArrayThree() {
	
		int temp[]=new int[3];
		int index[]=new int[3];
	
		for(int i=0;i<comp.getMaps().length;i++) {
		
			char ch=comp.getMaps().Array3.charAt(i);
		
			if(ch=='H') {
				index[0]=i;
				temp[0]++;
			}
			
			else if(ch=='E') {
				index[1]=i;
				temp[1]++;
			}
			
			else {
				index[2]=i;
				temp[2]++;
			}
			
			if(temp[0]==count[6][1])
				thecounts[2][1]=i;
		
			else if(temp[0]==count[6][2])
				thecounts[2][2]=i;
		
			else if(temp[0]==count[6][3])
				thecounts[2][3]=i;
		
			if(temp[1]==count[7][1])
				thecounts[2][6]=i;
		
			else if(temp[1]==count[7][2])
				thecounts[2][7]=i;
		
			else if(temp[1]==count[7][3])
				thecounts[2][8]=i;
		
			if(temp[2]==count[8][1])
				thecounts[2][11]=i;
				
			else if(temp[2]==count[8][2])
				thecounts[2][12]=i;
		
			else if(temp[2]==count[8][3])
				thecounts[2][13]=i;
		}	
		
		thecounts[2][4]=index[0];
		thecounts[2][9]=index[1];
		thecounts[2][14]=index[2];	
	}

	//Getting distribution values for attribute Van Der Waals Volume
	public void getCountsArrayFour() {
	
		int temp[]=new int[3];
		int index[]=new int[3];
	
		for(int i=0;i<comp.getMaps().length;i++) {
		
			char ch=comp.getMaps().Array4.charAt(i);
		
			if(ch=='H') {
				index[0]=i;
				temp[0]++;
			}
			
			else if(ch=='E') {
				index[1]=i;
				temp[1]++;
			}
			
			else {
				index[2]=i;
				temp[2]++;
			}
		
			if(temp[0]==count[9][1])
				thecounts[3][1]=i;
		
			else if(temp[0]==count[9][2])
				thecounts[3][2]=i;
		
			else if(temp[0]==count[9][3])
				thecounts[3][3]=i;
		
			if(temp[1]==count[10][1])
				thecounts[3][6]=i;
		
			else if(temp[1]==count[10][2])
				thecounts[3][7]=i;
		
			else if(temp[1]==count[10][3])
				thecounts[3][8]=i;
		
			if(temp[2]==count[11][1])
				thecounts[3][11]=i;	
		
			else if(temp[2]==count[11][2])
				thecounts[3][12]=i;
		
			else if(temp[2]==count[11][3])
				thecounts[3][13]=i;
		}	
		
		thecounts[3][4]=index[0];
		thecounts[3][9]=index[1];
		thecounts[3][14]=index[2];	
	}
	
	//Getting fractions of sequence where residue percentages occur
	public void setFinal() {
		System.out.println("\nDISTRIBUTION");
		String[] names={"HYDROPHOBICITY","POLARIZABILITY","POLARITY","VAN DER WAALS VOLUME"};
		
		//Display Data
		for(int i=0;i<4;i++) {
			System.out.println(names[i]);
			for(int j=0;j<15;j++) {
				thecounts[i][j]/=comp.getMaps().length;
				System.out.print(thecounts[i][j]+" ");
			}
			System.out.println();
		}
	}
}
