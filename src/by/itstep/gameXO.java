package by.itstep;

import java.util.Scanner;

/**
 * Created by st on 10.01.2018.
 */
public class gameXO {

    public static final int WIN_CONTINUE=0;
    public static final int WIN_1 =1;
    public static final int WIN_2 =2;
    public static final int DRAW=3;
    
    public static final char PLAYER_1='+';
    public static final char PLAYER_2='-';
    public static final char EMPTY='@';

    public static void main(String[] args) {
        char[][] gameField = {{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}};
        showGameField(gameField);
        int result;
        char symbol=PLAYER_1;
        do{
            makeMove(gameField,symbol);
            symbol=symbol==PLAYER_1?PLAYER_2:PLAYER_1;
            showGameField(gameField);
            result=checkField(gameField);
        }while (result==WIN_CONTINUE);

        showResult(result);

        makeMove(gameField, symbol);
        showGameField(gameField);
        makeMove(gameField, PLAYER_2);

        showGameField(gameField);

    }

    public static void showGameField(char[][] gameField) {
        System.out.println(gameField[0][0] + "|" + gameField[0][1] + "|" + gameField[0][2]);
        System.out.println("-----");
        System.out.println(gameField[1][0] + "|" + gameField[1][1] + "|" + gameField[1][2]);
        System.out.println("-----");
        System.out.println(gameField[2][0] + "|" + gameField[2][1] + "|" + gameField[2][2]);
        System.out.println();
    }

    public static void makeMove(char[][] gamefield, char symbol) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сейчас ходит " + symbol);
        int n;
        int m;
        int number;
        do {
            number = scanner.nextInt();
            n = 2 - (number - 1) / 3;
            m = (number - 1) % 3;


        } while (number < 1 || number > 9 || gamefield[n][m] != EMPTY);
        gamefield[n][m] = symbol;


        gamefield[n][m] = symbol;
    }

    public static int checkField(char[][] gamefield) {

        for (int i = 0; i < 3; i++) {
            if (gamefield[i][0] == gamefield[i][1] && gamefield[i][1] == gamefield[i][2])
            {
                if (gamefield[i][0] == PLAYER_1)
                    return WIN_1;


                if (gamefield[i][0] == PLAYER_2)
                    return WIN_2;


            }

            if (gamefield[0][i] == gamefield[1][i] && gamefield[1][i] == gamefield[2][i])
            {
                if (gamefield[0][i] == PLAYER_1)
                    return WIN_1;
                if (gamefield[0][i] == PLAYER_2)
                    return WIN_2;
            }

            if ((gamefield[0][0]==gamefield[1][1] && gamefield[1][1]==gamefield[2][2]) || (gamefield[0][2]==gamefield[1][1] && gamefield[1][1]==gamefield[2][0])){
                if (gamefield[1][1] == PLAYER_1)
                    return WIN_1;


                if (gamefield[1][1] == PLAYER_2)
                    return WIN_2;

            }


        }

        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                if (gamefield[i][j]==EMPTY)
                    return WIN_CONTINUE;


            }

        }

        return DRAW;


    }

    public static void showResult (int result){
        switch(result){
            case WIN_1:
                System.out.println("Победа"+PLAYER_1);
                break;
            case WIN_2:
                System.out.println("Победа"+PLAYER_2);
                break;
            case DRAW:
                System.out.println("Ничья");
        }

    }
}
