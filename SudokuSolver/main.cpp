#include <iostream>
#include "SudokuSolver.h"

int main() {
    //SudokuSolver S1;
    SudokuSolver S2("C:\\Users\\Krishna\\CLionProjects\\SudokuSolver\\input");
   // S1.solve();
   // S1.toString();
    S2.solve();
    S2.out_file("output");
}