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

    pair<int, int> Block1[] = {(0, 0), (0, 1), (0, 2), (1, 0), (1, 1), (1, 2), (2, 0), (2, 1), (2, 2)};
    pair<int, int> Block2[] = {(0, 3), (0, 4), (0, 5), (1, 3), (1, 4), (1, 5), (2, 3), (2, 4), (2, 5)};
    pair<int, int> Block3[] = {(0, 6), (0, 7), (0, 8), (1, 6), (1, 7), (1, 8), (2, 6), (2, 7), (2, 8)};
    pair<int, int> Block4[] = {(3, 0), (3, 1), (3, 2), (4, 0), (4, 1), (4, 2), (5, 0), (5, 1), (5, 2)};
    pair<int, int> Block5[] = {(3, 3), (3, 4), (3, 5), (4, 3), (4, 4), (4, 5), (5, 3), (5, 4), (5, 5)};
    pair<int, int> Block6[] = {(3, 6), (3, 7), (3, 8), (4, 6), (4, 7), (4, 8), (5, 6), (5, 7), (5, 8)};
    pair<int, int> Block7[] = {(6, 0), (6, 1), (6, 2), (7, 0), (7, 1), (7, 2), (8, 0), (8, 1), (8, 2)};
    pair<int, int> Block8[] = {(6, 3), (6, 4), (6, 5), (7, 3), (7, 4), (7, 5), (8, 3), (8, 4), (8, 5)};
    pair<int, int> Block9[] = {(6, 6), (6, 7), (6, 8), (7, 6), (7, 7), (7, 8), (8, 6), (8, 7), (8, 8)};

    int table[9][9];

    SudokuSolver(string fileAddres) {
        ifstream file;
        file.open(fileAddres);
        if (file == NULL) exit(1);
        rep(i, N) {
            rep(j, N) {
                string temp;
                file >> temp;
                if (temp == "-") table[i][j] = 0;
                else table[i][j] = stoi(temp);
            }
        }
    }

    SudokuSolver() {
        rep(i, N) {
            rep(j, N) {
                cin >> table[i][j];
            }
            getchar();
        }
    }

    void solve() {

    }

    bool solve(int grid[][N]){
        bool sol = false;
        pair<int,int> vacant = checkEmpty(grid);
        if(vacant.first == vacant.second == -1) return true;
        vector<int> option = possibleOptions(grid,vacant.first,vacant.second);
        if(option.size()==0) return false;
        for(auto i:option){
            grid[vacant.first][vacant.second] = i;
            if(solve(grid)){
                sol = true;
                break;
            }
        }
        return sol;
    }

    //check valid a,b and i,j at every point

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
                v.erase(remove(v.begin(), v.end(), grid[a][i]), v.end());
            }
        }
        rep(i, N) {
            if (grid[i][b] != 0) {
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
};

#endif //SUDOKUSOLVER_SUDOKUSOLVER_H
