package jsp.camera.rental;
import java.util.Scanner;
public class CameraMain {
	    public static void main(String[] args) {
	        Scanner Scanner = new Scanner(System.in);
	        System.out.println("WELCOME TO CAMERA RENTAL APP:");
	        System.out.println("USERNAME ");
	        String s1 = Scanner.nextLine();
	        System.out.println("PASSWORD ");
	        String s2 = Scanner.nextLine();

	        CameraRentalApp rentalApp = new CameraRentalApp();

	        // Sample camera
	        rentalApp.addCamera(new Camera("Canon", "EOS R5", 50.0));
	        rentalApp.addCamera(new Camera("Sony", "A7 III", 45.0));
	        rentalApp.addCamera(new Camera("Samsung", "DS123", 100.0));
	        rentalApp.addCamera(new Camera("Sony", "DSLR", 112.5));
	        rentalApp.addCamera(new Camera("Nikon", "DIGITAL", 150.0));
	        rentalApp.addCamera(new Camera("Panasonic", "LUMIX", 24.2));
	        
	        

	        while (true) {
	            System.out.println("1.MY CAMERA");
	            System.out.println("2.RENT A CAMERA");
	            System.out.println("3.VIEW ALL CAMERAS");
	            System.out.println("4.MY WALLET");
	            System.out.println("5.EXIT");
	            System.out.print("Enter your choice: ");

	            int choice = Scanner.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.println("1.ADD");
	                    System.out.println("2.REMOVE");
	                    System.out.println("3.VIEW MY CAMERAS");
	                    System.out.println("4.GO TO PREVIOUS MENU");
	                    int st = Scanner.nextInt();
	                    switch (st) {
	                        case 1:
	                            System.out.print("Enter the brand of the new camera: ");
	                            String brand = Scanner.next();
	                            System.out.print("Enter the model of the new camera: ");
	                            String model = Scanner.next();
	                            System.out.print("Enter the per-day rental amount: ");
	                            double rentalAmount = Scanner.nextDouble();
	                            rentalApp.addCamera(new Camera(brand, model, rentalAmount));
	                            System.out.println("New camera added successfully.");
	                            break;

	                        case 2:
	                            rentalApp.displayAvailableCameras();
	                            System.out.print("Enter the number of the camera to remove: ");
	                            int removeIndex = Scanner.nextInt();
	                            rentalApp.removeCamera(removeIndex);
	                            break;

	                        case 3:
	                            rentalApp.displayAvailableCameras();
	                            break;

	                        default:
	                            break;
	                    }
	                    break;
	                case 2:
	                    System.out.print("Enter the number of the camera you want to rent: ");
	                    int cameraIndex = Scanner.nextInt();
	                    rentalApp.rentCamera(cameraIndex);
	                    break;
	                case 3:
	                    rentalApp.displayAvailableCameras();
	                    break;
	                case 4:
	                    double balance = rentalApp.checkWalletBalance();
	                    System.out.println("Current wallet balance: " + balance);
	                    System.out.println("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET ?(1.YES  2.NO)");
	                    int ans = Scanner.nextInt();
	                    if (ans == 1) {
	                        System.out.print("Enter the amount to deposit: ");
	                        double depositAmount = Scanner.nextDouble();
	                        rentalApp.depositMoney(depositAmount);
	                    }
	                    break;
	                case 5:
	                    System.out.println("THANK YOU FOR USING. Goodbye!");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
	    }
	}

