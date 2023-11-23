public class BinairoSolver {
    public String solve(String s) throws Exception {
        int numberOfOnes = 0;
        int numberOfZeros = 0;
        int numberOfPoints = 0;
        try { if (s.length()%2 != 0){
            throw new Exception();
        }

        }
        catch (Exception exception){
            return "the binairo string is odd";
        }

        String mutate = s.replace(".11", "011")
                .replace("11.", "110")
                .replace(".00", "100")
                .replace("00.", "001")
                .replace("0.0", "010")
                .replace("1.1", "101");

        for (int i = 0; i < mutate.length(); i++) {
            if (mutate.charAt(i) == '1') {
                numberOfOnes++;
            }
            if (mutate.charAt(i) == '0') {
                numberOfZeros++;
            }
            if (mutate.charAt(i) == '.') {
                numberOfPoints++;
            }
        }

        if (numberOfOnes > numberOfZeros && numberOfPoints <= numberOfOnes ) {
            mutate = mutate.replace('.', '0');
            return mutate;
        } else if (numberOfZeros > numberOfOnes && numberOfPoints <= numberOfZeros) {
            mutate = mutate.replace('.', '1');
            return mutate;
        }
        return mutate;


    }
}

