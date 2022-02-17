import java.util.Scanner;


class Main {

    public static void main(String[] args) {
        System.out.println("Hello");

        Scanner in = new Scanner(System.in);
        int matrixSize = 0;
        System.out.println("Input Grille size");
        while(true) {
            matrixSize = in.nextInt();
            System.out.println("Your Input");
            System.out.println(matrixSize);
            if(matrixSize%2 == 1)
                System.out.println("Number can't be odd try again");
            else break;
        }
        System.out.println("Without rotation");
        Matrix matrix = new Matrix(Matrix.createListOfIncreasingNumbers(matrixSize));
        System.out.println(matrix.toString());

        System.out.println("After rotation 1");
        Matrix newMatrix = new Matrix(matrix.TurnRight());
        System.out.println(newMatrix.toString());

        System.out.println("After rotation 2");
        newMatrix = new Matrix(newMatrix.TurnRight());
        System.out.println(newMatrix.toString());

        System.out.println("After rotation 3");
        newMatrix = new Matrix(newMatrix.TurnRight());
        System.out.println(newMatrix.toString());

        System.out.println("After rotation 4");
        newMatrix = new Matrix(newMatrix.TurnRight());
        System.out.println(newMatrix.toString());

        System.out.println("Predict Positions");
        Matrix test = new Matrix(matrix.getElementRotatePositions(2,3));
        System.out.println(test.toString());














    }


}