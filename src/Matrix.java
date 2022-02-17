import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private List<List<Integer>> matrixValues;
    private int rowSize;

    public Matrix(List<List<Integer>> matrixValues) {
        this.matrixValues = matrixValues;
        this.rowSize = matrixValues.size();
    }

    public int getRowSize() {
        return rowSize;
    }

    public List<List<Integer>> getMatrixValues() {
        return matrixValues;
    }

    public void setMatrixValues(List<List<Integer>> matrixValues) {
        this.matrixValues = matrixValues;
    }
    public void setRow(List<Integer> row, int rowIndex){
        matrixValues.set(rowIndex, row);
    }
    public void setColumn(List<Integer> column, int columnIndex){
        for (int i = 0; i < matrixValues.size(); i++)
        {
            List<Integer> tmpRow = matrixValues.get(i);
            tmpRow.set(columnIndex, column.get(i));
        }



    }

    public static List<List<Integer>> createListOfIncreasingNumbers(int size){
        List<List<Integer>> newMatrix = new ArrayList<>();
        for (int i =0; i < size; i++){

            List<Integer> tmp = new ArrayList<>();
            for (int j =0; j < size; j++){
                tmp.add(j, i*size+j);
            }
            newMatrix.add(i,tmp);

        }
        return newMatrix;
    }


    public List<List<Integer>> TurnRight(){
        int size = matrixValues.size();
        List<List<Integer>> newMatrix = Matrix.createListOfIncreasingNumbers(size);


        for(int i = 0; i < size; i++){                        // j = столбец исходной матрицы
            for (int j = 0; j < size; j++){                   // i = строка исходной матрицы => столбец повернутой
                List<Integer> currentRow = newMatrix.get(j);
                int newColumnIndex = size - Consts.VALUE_OF_ONE -i;
                int newRowIndex = matrixValues.get(i).get(j);
                currentRow.set(newColumnIndex, newRowIndex);
            }

        }
        return newMatrix;

    }

    public int getValueOfCell(int rowIndex, int columnIndex){
        return matrixValues.get(rowIndex).get(columnIndex);
    }

    public  List<Integer> getPositionByValue(int value){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < rowSize; i++){
            for (int j = 0; j<rowSize; j++){
                if(matrixValues.get(i).get(j)==value){
                    result.add(0,i);
                    result.add(1,j);
                    return result;
                }

            }
        }
        return result;

    }

    public Matrix createCopy(){

        List<List<Integer>> newMatrixValues = new ArrayList<>();
        for(int i = 0; i < rowSize; i++){
            for (int j = 0; j<rowSize; j++){
                Integer tmpCell = matrixValues.get(i).get(j);
                newMatrixValues.get(i).set(j, tmpCell);
                }

            }
        return  new Matrix(newMatrixValues);
    }

    public List<List<Integer>> getElementRotatePositions(int rowIndex, int columnIndex){
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Consts.NUMBER_OF_STEPS; i++){
            int newRowIndex = columnIndex;
            int newColumnIndex = rowSize - Consts.VALUE_OF_ONE - rowIndex;
            List<Integer> tmp = new ArrayList<>();
            tmp.add(0,newRowIndex);
            tmp.add(1,newColumnIndex);
            result.add(i,tmp);
            rowIndex = newRowIndex;
            columnIndex = newColumnIndex;
        }
        return result;
    }




    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i=0; i < matrixValues.size(); i++){
            result.append("[");
            for(int j = 0; j < matrixValues.get(i).size(); j++){
                List<Integer> tmpRow = matrixValues.get(i);
                result.append(" ");
                result.append(tmpRow.get(j));
            }
            result.append(" ]\n");
        }

        return result.toString();
    }
}
