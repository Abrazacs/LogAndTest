import java.util.Arrays;

public class HomeWorkTestAndLog {

    public int[] checkTheArray (int [] array) throws RuntimeException {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) index = i+1;
        }
        if (index == 0) throw new RuntimeException("Initial array doesn't contain 4");
        if (index == array.length) return new int[0];
        else {
            int [] newArray = new int[array.length-index];
            for (int i = 0; i < newArray.length ; i++) {
                newArray[i] = array[index];
                index++;
            }
            return newArray;
        }
    }
    
    public boolean checkIfArrayContainsOneAndFour (int [] array){
        boolean containsOne = false;
        boolean containsFour = false;
        for (int value: array) {
            if (value == 1) containsOne = true;
            if (value == 4) containsFour =true;
            if (value !=1 && value != 4) return false;
        }
        return false;
    }
    
}

