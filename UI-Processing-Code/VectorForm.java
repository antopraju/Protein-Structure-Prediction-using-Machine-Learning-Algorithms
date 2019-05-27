package io.code;

//Formation of feature vector based on values obtained by objects of other classes
public class VectorForm {
	
	//Objects created of each class
	private Maps maps;
	private Composition comp;
	private Transition trans;
	private PercentFrequency percent;
	private Distribution distro;
	
	//Storing the feature vector
	//Two dimensional array created so that row can indicate protein number when we read from files
	float [][] featureVector = new float[1][105];
	
	//Keeping track of index in feature vector
	int index=-1;
	
	//Constructor wish methods called by object
	public VectorForm(Maps maps, Composition comp, Transition trans, Distribution distro, PercentFrequency percent) {
		this.maps=maps;
		this.comp=comp;
		this.trans=trans;
		this.percent=percent;
		this.distro=distro;
		this.getComposition();
		this.getTransition();
		this.getDistribution();
		this.getPercentFrequency();
		this.getMapsLength();
		this.displayFeatureVector();
	}
	
	//Adding one dimensional array obtained from composition object to feature vector
	void getComposition() {
		float temp[] = new float[12];
		temp=comp.getVector();

		for(int i=0;i<12;i++) {
			++index;
			featureVector[0][index]=temp[i];
		}
	}
	
	//Adding one dimensional array obtained from transition object to feature vector
	void getTransition() {
		float temp[] = new float[12];
		temp=trans.getVector();
		
		for(int i=0;i<12;i++) {
			++index;
			featureVector[0][index]=temp[i];
		}
	}
	
	//Adding one dimensional array obtained from distribution object to feature vector
	void getDistribution() {
		float temp[] = new float[60];
		temp=distro.getVector();
		for(int i=0;i<60;i++) {
			++index;
			featureVector[0][index]=temp[i];
		}
	}
	
	//Adding one dimensional array obtained from PercentFrequency object to feature vector
	void getPercentFrequency() {
		float temp[] = new float[20];
		temp=percent.getVector();
		for(int i=0;i<20;i++) {
			++index;
			featureVector[0][index]=temp[i];
		}
	}
	
	//Adding protein length obtained from Maps object to feature vector
	void getMapsLength() {
		++index;
		featureVector[0][index]=maps.length;
	}
	
	//Displaying feature vector of length 105
	void displayFeatureVector() {
		System.out.println("FINAL FEATURE VECTOR");
		for(int i=0;i<105;i++) {
			System.out.println(featureVector[0][i]+" ");
		}
	}
}
