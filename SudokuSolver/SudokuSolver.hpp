#include <stdio.h>
#include <cmath.h>
#include <fstream.h>

class SudokuSolver{
public:
	int table[9][9];
	SudokuSolver(String fileAddres){
		ifstream file;
		file.open(fileAddres);
		if(file==null) exit(1);
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				String temp;
				file >> temp;
				if(temp.equals('-')) a[i][j] = 0;
				else a[i][j] = stoi(temp);
			}
		}
		
	}
	SudokuSolver(){

	}
	void solve(){

	}

	bool check(int a,int i,int j){

	}
}