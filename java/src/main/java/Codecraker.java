/**
 * Created by sonalisharma on 7/17/14.
 */
import java.util.Arrays;
public class Codecraker {

    private int[] code;

    public Codecraker()
    {
        //System.out.println("Generated Number"+generateNumber().toString());
        this.code = generateNumber();
    }
    public int[] generateNumber() {
        {
            int[] gen = new int[4];
            for (int i = 0; i < 4; i++) {
                gen[0] = (int) (Math.random() * 10);

                gen[1] = (int) (Math.random() * 10);
                while (gen[1] == gen[0]) {
                    gen[1] = (int) (Math.random() * 10);
                }
                gen[2] = (int) (Math.random() * 10);
                while (gen[2] == gen[0] || gen[2] == gen[1]) {
                    gen[2] = (int) (Math.random() * 10);
                }
                gen[3] = (int) (Math.random() * 10);
                while (gen[3] == gen[0] || gen[3] == gen[1] || gen[3] == gen[2]) {
                    gen[3] = (int) (Math.random() * 10);
                }
            }

            return gen;

        }


    }

    public boolean validateNumber(String input) {
        try {
            Integer.parseInt(input);
            if (input.length() == 4) return true;
        } catch (Exception e) {
        }

        return false;
    }

    public String generateClue(String s) {
        char[] input = s.toCharArray();
        System.out.println(input);
        System.out.println("Code");
        System.out.println(this.code);
        if (validateNumber(s)) {
            int result[] = {0, 0, 0, 0};
            int position = 0;
            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    //System.out.println(input[b]);
                    if ((int) input[b] == code[a]) {
                        if (a == b)
                            result[position] = 2;
                        else
                            result[position] = 1;
                    }
                }
                position++;
            }
            Arrays.sort(result);

            System.out.println("============Result");
            System.out.println(result);
            System.out.println("============");

            for (int i = 0; i < 2; i++) {
                int temp = result[i];
                result[i] = result[result.length - 1 - i];
                result[result.length - 1 - i] = temp;
            }

           String res = Arrays.toString(result);
           System.out.println("============");
           System.out.println(res);
           System.out.println("============");
           return res;
        }
        else
        {
            return "Invalid input - code is only numbers";
        }

    }


    @Override
    public boolean equals(Object other)
    {
        if (other == this) return true;
        if (!(other instanceof String)) return false;
        String otherNumber = (String)other;
       // double Othervalue = otherScaledQuantity.unit.convertTo(otherScaledQuantity.value, this.unit);
        return Integer.parseInt(this.code.toString()) == Integer.parseInt(otherNumber);
    }

    @Override
    public int hashCode(){
        // you can give any value here
        return 42;
    }



}


