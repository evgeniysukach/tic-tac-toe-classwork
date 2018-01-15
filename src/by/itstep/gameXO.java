package by.itstep;

import java.util.Scanner;

/**
 * Created by st on 10.01.2018.
 */
public class gameXO {

    public static void main(String[] args) {
        char[][] gameField = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        showGameField(gameField);
        int result;
        char symbol='x';
        do{
            makeMove(gameField,symbol);
            symbol=symbol=='x'?'0':'x';
            showGameField(gameField);
            result=checkField(gameField);
        }while (result==0);7

        switch(result){
            case 1:
                System.out.println("Победа Х");
                break;
            case 2:
                System.out.println("Победа Y");
                break;
            case 3:
                System.out.println("Ничья");
        }







        makeMove(gameField, symbol);
        showGameField(gameField);
        makeMove(gameField, '0');

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


        } while (number < 1 || number > 9 || gamefield[n][m] != ' ');
        gamefield[n][m] = symbol;


        gamefield[n][m] = symbol;
    }

    public static int checkField(char[][] gamefield) {

        for (int i = 0; i < 3; i++) {
            if (gamefield[i][0] == gamefield[i][1] && gamefield[i][1] == gamefield[i][2])
            {
                if (gamefield[i][0] == 'x')
                    return 1;


                if (gamefield[i][0] == '0')
                    return 2;


            }

            if (gamefield[0][i] == gamefield[1][i] && gamefield[1][i] == gamefield[2][i])
            {
                if (gamefield[0][i] == 'x')
                    return 1;
                if (gamefield[0][i] == '0')
                    return 2;
            }

            if ((gamefield[0][0]==gamefield[1][1] && gamefield[1][1]==gamefield[2][2]) || (gamefield[0][2]==gamefield[1][1] && gamefield[1][1]==gamefield[2][0])){
                if (gamefield[1][1] == 'x')
                    return 1;


                if (gamefield[1][1] == '0')
                    return 2;

            }


        }

        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                if (gamefield[i][j]==' ')
                    return 0;


            }

        }

        return 3;


    }
}
