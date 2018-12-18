//
// Created by Vaastav Arora on 12/15/2018.
//

#ifndef SUDOKUSOLVER_SUDOKUSOLVER_H
#define SUDOKUSOLVER_SUDOKUSOLVER_H

#include <stdio.h>
#include <bits/stdc++.h>
#include <algorithm>
#include <cmath>
#include <fstream>
#include <iostream>

#define rep(i, a) for(int i=0;i<a;i++)
#define N 9

using namespace std;

class SudokuSolver {
public:
    int table[9][9];

    SudokuSolver(string file_addres) {
        ifstream file;
        file.open(file_addres);
        if (file.fail()) {
            cerr << "Error Opening file\n";
            exit(1);
        }
        rep(i, N) {
            rep(j, N) {
                string temp;
                file >> temp;
               // cout << temp << "i" << endl;
                if (temp == "-") table[i][j] = 0;
                else table[i][j] = stoi(temp);
            }
        }
    }

    SudokuSolver() {
        printf("Enter Sudoku Table:\n");
        rep(i, N) {
            rep(j, N) {
                cin >> table[i][j];
            }
            getchar();
        }
    }

    void solve() {
        solveR(table);
    }

    //check valid a,b and i,j at every point





    string toString(){
        int count = 0;
        string out = "";
        for(int i=0;i<N;i++){
            if(i%3==0) out+=part;
            for(auto j:table[i]){
                if(count%3==0) out+="| ";
                out += (j+48);
                out+=" ";
                count++;
            }
            out+="|\n";
        }
        out+=part;

        return out;
    }

    void out_file(string file_name){
        ofstream file;
        file.open(file_name);
        if(file.fail()) {
            std::cerr << "Error Opening File";
            exit(1);
        }

        file << toString();
    }



private:
    string part = "-------------------------\n";

    bool solveR(int grid[][N]){
        pair<int,int> vacant = checkEmpty(grid);
        if(vacant.first == -1) return true;
        vector<int> option = possibleOptions(grid,vacant.first,vacant.second);
        if(option.size()==0) return false;
        for(auto i:option){
            grid[vacant.first][vacant.second] = i;
            if(solveR(grid)){
                return true;
            }
        }
        grid[vacant.first][vacant.second] = 0;
        return false;
    }

    pair<int, int> checkEmpty(int grid[][N]) {
        rep(i, N) {
            rep(j, N) {
                if (grid[i][j] == 0) {
                    pair<int, int> temp{i, j};
                    return temp;
                }
            }
        }
        pair<int, int> temp{-1, -1};
        return temp;
    }

    vector<int> possibleOptions(int grid[][N], int a, int b) {
        vector<int> v{1, 2, 3, 4, 5, 6, 7, 8, 9};
        rep(i, N) {
            if (grid[a][i] != 0) {
                //cout << grid[a][i] << " col " << endl;
                v.erase(remove(v.begin(), v.end(), grid[a][i]), v.end());
            }
        }
        rep(i, N) {
            if (grid[i][b] != 0) {
                // cout << grid[i][b] << " row " << endl;
                v.erase(remove(v.begin(), v.end(), grid[i][b]), v.end());
            }
        }
        if(a<3 && b<3) op2(v,Block1,grid);
        else if(a<3 && b<6) op2(v,Block2,grid);
        else if (a<3) op2(v,Block3,grid);
        else if(a<6 && b<3) op2(v,Block4,grid);
        else if(a<6 && b<6) op2(v,Block5,grid);
        else if(a<6) op2(v,Block6,grid);
        else if(b<3) op2(v,Block7,grid);
        else if(b<6) op2(v,Block8,grid);
        else  op2(v,Block9,grid);

        return v;

    }

    void op2(vector<int>& v,pair<int,int> block[], int grid[][N]){
        rep(i,N){
            if(grid[block[i].first][block[i].second]!=0)  v.erase(remove(v.begin(),v.end(),grid[block[i].first][block[i].second]),v.end());
        }
    }


    pair<int, int> Block1[9] {make_pair(0, 0), make_pair(0, 1), make_pair(0, 2), make_pair(1, 0), make_pair(1, 1), make_pair(1, 2), make_pair(2, 0), make_pair(2, 1), make_pair(2, 2)};
    pair<int, int> Block2[9] = {make_pair(0, 3), make_pair(0, 4), make_pair(0, 5), make_pair(1, 3), make_pair(1, 4), make_pair(1, 5), make_pair(2, 3), make_pair(2, 4), make_pair(2, 5)};
    pair<int, int> Block3[9] = {make_pair(0, 6), make_pair(0, 7), make_pair(0, 8), make_pair(1, 6), make_pair(1, 7), make_pair(1, 8), make_pair(2, 6),make_pair (2, 7), make_pair(2, 8)};
    pair<int, int> Block4[9] = {make_pair(3, 0), make_pair(3, 1), make_pair(3, 2), make_pair(4, 0), make_pair(4, 1), make_pair(4, 2), make_pair(5, 0), make_pair(5, 1), make_pair(5, 2)};
    pair<int, int> Block5[9] = {make_pair(3, 3), make_pair(3, 4), make_pair(3, 5), make_pair(4, 3), make_pair(4, 4), make_pair(4, 5), make_pair(5, 3), make_pair(5, 4), make_pair(5, 5)};
    pair<int, int> Block6[9] = {make_pair(3, 6), make_pair(3, 7), make_pair(3, 8), make_pair(4, 6), make_pair(4, 7), make_pair(4, 8), make_pair(5, 6), make_pair(5, 7), make_pair(5, 8)};
    pair<int, int> Block7[9] = {make_pair(6, 0), make_pair(6, 1), make_pair(6, 2), make_pair(7, 0), make_pair(7, 1), make_pair(7, 2), make_pair(8, 0), make_pair(8, 1), make_pair(8, 2)};
    pair<int, int> Block8[9] = {make_pair(6, 3), make_pair(6, 4), make_pair(6, 5), make_pair(7, 3), make_pair(7, 4), make_pair(7, 5), make_pair(8, 3), make_pair(8, 4), make_pair(8, 5)};
    pair<int, int> Block9[9] = {make_pair(6, 6), make_pair(6, 7), make_pair(6, 8), make_pair(7, 6), make_pair(7, 7), make_pair(7, 8), make_pair(8, 6), make_pair(8, 7), make_pair(8, 8)};
};

#endif //SUDOKUSOLVER_SUDOKUSOLVER_H
