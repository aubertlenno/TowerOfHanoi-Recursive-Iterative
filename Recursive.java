public class Recursive {
    public static String showMovesRecursion(int n, char startPeg, char destPeg, char tempPeg) {
        if (n == 1) {
            return "Move disk 1 from peg " + startPeg + " to peg " + destPeg + "\n";
        } else {
            return showMovesRecursion(n - 1, startPeg, tempPeg, destPeg)
                    + "Move disk " + n + " from peg " + startPeg
                    + " to peg " + destPeg + "\n"
                    + showMovesRecursion(n - 1, tempPeg, destPeg, startPeg);
        }
    }


    public static void main(String[] args) {
        double startTime = System.currentTimeMillis();

        int nDisks = 3;
        String movesRecursion = Recursive.showMovesRecursion(nDisks, 'L', 'R', 'M');
        System.out.println(movesRecursion);

        double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;

        System.out.println("Recursive function run time = " + totalTime + " ms");

    }
}
