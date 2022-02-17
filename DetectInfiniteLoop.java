import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
    Author @Vaibhav Sharma (aka technogust) (GitHub profile: https://github.com/technogust)
   This program will detect the infinite loop. There can be many scenarios where an infinite loop condition may occur.
   However, in this program I am taking increment/decrement scenario. Again there can be other increment/decrement kind
   of scenarios. But I am using "++"/"--" in this case.
   The algorithm is as follows:
    1. Take a variable, I am naming it "a" in my case [for incrementing loop] and a [for decrementing loop].
    2. Add the max_limit in case of increment condition / min_limit in case of decrement
    3. Increment by max_limit + 1. see if the program is stopping. If the program is stopping we are sure that the
        loop will not be infinite if "a" is always incrementing. In case of decrement: Decrement by min_limit - 1.
        see if the program is stopping. If the program is stopping we are sure that the
        loop will not be infinite if "a" is always decrementing.
    4. Find if it is incrementing or decrementing for a given condition. I am using pattern matching in my case to
        achieve this.
    5. If the incrementing/decrementing condition is found, it means the loop is not infinite, otherwise the loop is
        infinite.
*/


public class DetectInfiniteLoop {

    public static void main(String args[]) throws IOException{

        //defining variables and assigning values to some
        int a = 0;
        int max_limit = 1000;
        int min_limit = -1000;
        boolean increment;
        boolean decrement;

        //Increment Pattern (a++ in this case)
//        Pattern isIncrementing = Pattern.compile("[a][+][+]");
//
//        // PrintWriter will add the contents of println in looplogic.txt file. In this program I am using looplogic.txt file
//        //just as a placeholder (not sure if the terminology "place holder" is correct in this scenario.
//        PrintWriter out = new PrintWriter("./looplogic.txt");
//        out.println(" a = 0 ; a < max_limit; )");
//        out.close();
//        File file = new File("./looplogic.txt");
//
//        // just scanning the looplogic.txt file
//        Scanner scan = new Scanner(file);
//
//        //file will be empty if increment pattern doesn't match so the String "shouldNotBlankIfIncrementing" will also be empty
//        String shouldNotBlankIfIncrementing = scan.findAll(isIncrementing).map(MatchResult::group).collect(Collectors.joining("\n"));
//        increment = !shouldNotBlankIfIncrementing.isEmpty();
//        //System.out.println(shouldNotBlankIfIncrementing.isEmpty());
//        System.out.println(shouldNotBlankIfIncrementing);
//        scan.close();
//
//
//        // loop with pre-defined condition, this loop may or may not be infinite depending on the condition
//        // make sure that the "out" (PrintWriter variable name) must have the for loop's pre-defined condition
//        for ( a = 0 ; a < max_limit; ){
//            System.out.println("Hello I may be in an infinite loop");
//            int upperExitLimit = max_limit + 1;
//            int b;
//            for(b=a; b< upperExitLimit; b++){
//                if(b<upperExitLimit) {
//                    System.out.println("Hello I am not in an infinite loop only if a is incrementing.");
//                }
//                b= b + upperExitLimit;
//            }
//            System.out.println("Checking If a is incrementing");
//            if (increment == true){
//                System.out.println("Hello a is incrementing so I am not in an infinite loop");
//                break;
//            }
//            else{
//                System.out.println("As a is not incrementing");
//                System.out.println("So, I am surely in an infinite loop");
//                break;
//            }
//        }



        //Decrement Pattern (a-- in this case)
        Pattern isDecrementing = Pattern.compile("[a][-][-]");

        // PrintWriter will add the contents of println in dlooplogic.txt file. In this program I am using dlooplogic.txt file
        //just as a placeholder (not sure if the terminology "place holder" is correct in this scenario.
        PrintWriter dOut = new PrintWriter("./dlooplogic.txt");
        dOut.println(" a = 0 ; a > min_limit; )");
        dOut.close();
        File dFile = new File("./dlooplogic.txt");

        // just scanning the looplogic.txt file
        Scanner scan2 = new Scanner(dFile);

        //file will be empty if increment pattern doesn't matches so the String "shouldNotBlankIfDecrementing" will also be empty
        String shouldNotBlankIfDecrementing = scan2.findAll(isDecrementing).map(MatchResult::group).collect(Collectors.joining("\n"));
        decrement = !shouldNotBlankIfDecrementing.isEmpty();
        System.out.println(shouldNotBlankIfDecrementing.isEmpty());
        System.out.println(shouldNotBlankIfDecrementing);
        scan2.close();


        // loop with pre-defined condition, this loop may or may not be infinite depending on the condition
        // make sure that the "out" (PrintWriter variable name) must have the for loop's pre-defined condition
        for ( a = 0 ; a > min_limit; ){
            System.out.println("Hello I may be in an infinite loop");
            int lowerExitLimit = min_limit - 1;
            int b;
            for(b=a; b> lowerExitLimit; b--){
                if(b>lowerExitLimit) {
                    System.out.println("Hello I am not in an infinite loop only if a is decrementing.");
                }
                b= b + lowerExitLimit;
            }
            System.out.println("Checking If a is decrementing");
            if (decrement == true){
                System.out.println("Hello a is decrementing so I am not in an infinite loop");
                break;
            }
            else{
                System.out.println("As a is not decrementing");
                System.out.println("So, I am surely in an infinite loop");
                break;
            }
        }
    }

}
