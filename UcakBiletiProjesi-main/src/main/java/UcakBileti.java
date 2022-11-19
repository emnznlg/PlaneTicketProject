import java.util.Scanner;

public class UcakBileti {
    public static void main(String[] args) {
        int distance = 0, age, typeOfTravelling;
        double normalPrice = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter distance (KM): ");
        distance = input.nextInt();

        System.out.print("Please enter your age: ");
        age = input.nextInt();

        System.out.print("Enter type of travelling (1->One direction , 2->Doubledirection): ");
        typeOfTravelling = input.nextInt();

        if (distance > 0){
            normalPrice = distance * 0.1;
        }
        else{
            System.out.println("Please enter number bigger than 0 !");
        }

        if (age > 0){
            if (age < 12){
                normalPrice -= (normalPrice * 0.5);
            }
            else if((age >= 12) && (age <=24)){
                normalPrice -= (normalPrice * 0.1);
            }
            else if(age >65){
                normalPrice -= (normalPrice * 0.3);
            }
        }
        else{
            System.out.println("Please enter number bigger than 0 for age!");
        }

        if ((typeOfTravelling == 1) || (typeOfTravelling == 2)){
            if (typeOfTravelling == 2){
                normalPrice -= (normalPrice * 0.2);
                normalPrice*= 2;
            }
        }
        else{
            System.out.println("Please enter 1 or 2 for type of travelling");
        }

        System.out.println("Total Price : " + normalPrice + " $");
    }
}

