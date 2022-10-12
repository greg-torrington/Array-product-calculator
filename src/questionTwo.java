import java.util.*;

public class questionTwo {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter order number: ");
        int order = Integer.parseInt(sc.nextLine());
        System.out.print("Enter carton sizes use a comma seperated list (e.g. 1,2,3): ");
        String[] cartonSizesString = sc.nextLine().split(",");

        int[] cartonSizes = new int[cartonSizesString.length];
        for (int i=0; i<cartonSizes.length; i++){
            cartonSizes[i] = Integer.parseInt(cartonSizesString[i]);
        }

        if ( (order>1000) || (order<0) || (cartonSizes.length < 1 ) || (cartonSizes.length > 6 ) ){
            System.out.println("Input error");
        } else {

            Arrays.sort(cartonSizes);

            if ( cartonSizes[cartonSizes.length-1] > 6 || cartonSizes[0] < 1 ){
                System.out.println("Input error");
            } else {

                int finalAnswer = 0;
                for (int i=0; i<cartonSizes.length; i++){
                    int answer = workoutKooladesToPack(order, cartonSizes, cartonSizes[i], 0);
                    if (finalAnswer<answer){
                        finalAnswer = answer;
                    }
                }

                System.out.println(finalAnswer);
            }

        }
    }

    public static int workoutKooladesToPack(int order, int[] cartonSizes, int cartonSizeToAdd, int kooladesToPack){

        if (kooladesToPack + cartonSizeToAdd > order){
            return kooladesToPack;
        } else if ( kooladesToPack + cartonSizeToAdd == order ){
            return kooladesToPack + cartonSizeToAdd;
        }

        kooladesToPack += cartonSizeToAdd;

        for (int i=0; i<cartonSizes.length; i++){
            return workoutKooladesToPack(order, cartonSizes, cartonSizes[i], kooladesToPack);
        }
        return 0;
    
    }
}
