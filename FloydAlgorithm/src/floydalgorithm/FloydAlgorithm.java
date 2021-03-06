package floydalgorithm;

public class FloydAlgorithm {

    private static int calls = 1;
    private static String inf = "9999";

    public static void main(String[] args) {
        String inputMtx[][] = {
            {"0", "10", "∞", "∞", "∞", "5", "∞", "∞", "∞", "∞"}, // A
            {"∞", "0", "3", "∞", "3", "∞", "∞", "∞", "∞", "∞"}, // B
            {"∞", "∞", "0", "4", "∞", "∞", "∞", "5", "∞", "∞"}, // C
            {"∞", "∞", "∞", "0", "∞", "∞", "∞", "∞", "4", "∞"}, // D
            {"∞", "∞", "4", "∞", "0", "∞", "2", "∞", "∞", "∞"}, // E
            {"∞", "3", "∞", "∞", "∞", "0", "∞", "∞", "∞", "2"}, // F
            {"∞", "∞", "∞", "7", "∞", "∞", "0", "∞", "∞", "∞"}, // G
            {"∞", "∞", "∞", "4", "∞", "∞", "∞", "0", "3", "∞"}, // H
            {"∞", "∞", "∞", "∞", "∞", "∞", "∞", "∞", "0", "∞"}, // I
            {"∞", "6", "∞", "∞", "∞", "∞", "8", "∞", "∞", "0"} // J
        };
        for (int i = 0; i < inputMtx.length; i++) {
            for (int j = 0; j < inputMtx.length; j++) {
                if (inputMtx[i][j].equalsIgnoreCase("∞")) {
                    inputMtx[i][j] = inf;//99999
                }
            }
        }
        System.out.println("------------------Testing Floyd Warshall Algorithm------------------------"
                + "\n\nThe weight matrix:");
        print(inputMtx);
        System.out.println("=========================================================================="
                + "\nThe distance matrix:");
        ApplyFloyd(inputMtx);
    }

    public static void ApplyFloyd(String[][] mtx) {
        for (int i = 0; i < mtx.length; i++) { // this is for rows
            for (int j = 0; j < mtx.length; j++) { // this is for column
                for (int k = 0; k < mtx.length; k++) { // this is for elements goes by [row, column] aka [j,i]
                    // if element (x=infinity)> element in row + element in column,
                    // then put the sum result in element x. () 
                    if (Integer.parseInt(mtx[j][i]) + Integer.parseInt(mtx[i][k]) < Integer.parseInt(mtx[j][k])) {
                        int element = Integer.parseInt(mtx[j][i]) + Integer.parseInt(mtx[i][k]);
                        mtx[j][k] = Integer.toString(element);
                    }
                }
                // here will show changes each row
                System.out.println("\nD" + calls + ":");
                print(mtx);
            }
            System.out.println("==========================================================================");
            // here will print the final weight matrix each time ex: D1, D2, ... only 
            System.out.println("\nD" + calls + ":");
            print(mtx);
            calls++; // to print D1, D2, etc
        }
    }

    public static void print(String graph[][]) {
        System.out.println("\nD" + calls + ":");
        System.out.println("A	B	C	D	E	F	G	H	I	J\n"
                + "--------------------------------------------------------------------------");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j].equalsIgnoreCase(inf)) {
                    System.out.printf("%s\t", "∞");
                } else {
                    System.out.printf("%s\t", graph[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------");
    }
}
