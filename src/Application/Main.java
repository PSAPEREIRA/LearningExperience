package Application;

import ComposedClassesEntities.*;
import ExceptionExerciseEntitities.Account;
import ExceptionExerciseEntitities.DomainException;
import ExerciseAbstractEntities.Company;
import ExerciseAbstractEntities.Individual;
import ExerciseAbstractEntities.TaxPayer;
import InheritanceCastedClassesEntities.ImportedProducts;
import InheritanceCastedClassesEntities.Products;
import InheritanceCastedClassesEntities.UsedProducts;
import SingleExercisesEntities.*;
import SortedExercises.CurrencyConverter;

import javax.imageio.IIOException;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    public static void main(String[] args) throws ParseException, IOException {

        //Local para PT
        Locale ptPortugal = new Locale("pt", "PT");
        Locale.setDefault(ptPortugal);

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int opt;

        do {

            System.out.println("\nPick an option:\n1-Rectangle Calculus\n2-Employee Salary\n3-Student Grades");
            System.out.println("4-Currency Converter\n5-Product\n6-BankAccount\n7-RoomRentVector\n8-ListEmployee");
            System.out.println("9-ArrayOfArray\n10-ClientOrder\n11-ProductsNew&Used\n12-TaxPayment\n13-AccountException");
            System.out.println("14-Read From File\n15- Write to file\n0-QUIT\n");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    Rectangle rectangle = new Rectangle();

                    System.out.println("Define the width of the rectangle:");
                    rectangle.width = sc.nextDouble();

                    System.out.println("Define the height of the rectangle:");
                    rectangle.height = sc.nextDouble();

                    System.out.printf("The area of the rectangle is: %.2f%n", rectangle.area());
                    System.out.printf("The perimeter of the rectangle is: %.2f%n", rectangle.perimeter());
                    System.out.printf("The diagonal of the rectangle is: %.2f%n", rectangle.diagonal());
                    sc.close();
                    break;

                case 2:
                    Employee employee = new Employee();
                    double percentage;

                    System.out.println("Name of the employee:");
                    employee.name = sc.nextLine();

                    System.out.println("Employee Gross Salary:");
                    employee.grossSalary = sc.nextDouble();

                    System.out.println("Employee tax:");
                    employee.tax = sc.nextDouble();

                    //System.out.printf("Employee:"+employee.name+", "+employee.netSalary()+"€");

                    System.out.println();
                    System.out.println("Employee: " + employee);
                    System.out.println();

                    System.out.println("Which percentage to increase salary?");
                    percentage = sc.nextDouble();
                    employee.increaseSalary(percentage);

                    System.out.println();
                    System.out.println("Updated data: " + employee);
                    sc.close();
                    break;

                case 3:

                    Student student = new Student();

                    double finalGrade, missingPoints;

                    System.out.println("Student Name:");
                    student.name = sc.next();

                    System.out.println("1st trimester grade:");
                    student.grade1 = sc.nextDouble();

                    System.out.println("2nd trimester grade:");
                    student.grade2 = sc.nextDouble();

                    System.out.println("3rd trimester grade:");
                    student.grade3 = sc.nextDouble();

                    finalGrade = student.finalGradeCalc();

                    System.out.printf("Student: " + student.name + "\nFinal grade:%.2f%n", finalGrade);

                    if (finalGrade >= 60.00) {
                        System.out.println("PASS");
                    } else {
                        missingPoints = student.missingPointsCalc();
                        System.out.printf("FAILED\nMISSING %.2f%n POINTS", missingPoints);
                    }
                    sc.close();
                    break;

                case 4:

                    double dollarPrice, amountDollar, amountConverted;

                    System.out.println("What is the current dollar price?");
                    dollarPrice = sc.nextDouble();

                    System.out.println("What is the total amount to be bought?");
                    amountDollar = sc.nextDouble();

                    amountConverted = CurrencyConverter.converter(amountDollar, dollarPrice);

                    amountConverted += amountConverted * CurrencyConverter.IOF;

                    System.out.printf("The amount to be paid in Euros with tax= %.2f€\n", amountConverted);
                    sc.close();
                    break;

                case 5:

                    String productName;
                    double productPrice;
                    int quantity;

                    System.out.println("Enter product data: ");

                    System.out.print("Product Name:");
                    productName = sc.nextLine();

                    System.out.print("Product Price:");
                    productPrice = sc.nextDouble();

                    ProductsSingle productsSingle = new ProductsSingle(productName, productPrice);

                    System.out.println();
                    System.out.print("Product data: " + productsSingle);

                    System.out.println();
                    System.out.print("Enter the number of products to be added in stock: ");
                    quantity = sc.nextInt();
                    productsSingle.addProducts(quantity);

                    System.out.println();
                    System.out.print("Product updated data: " + productsSingle);

                    System.out.println();
                    System.out.print("Enter the number of products to be removed in stock: ");
                    quantity = sc.nextInt();
                    productsSingle.removeProducts(quantity);

                    System.out.println();
                    System.out.print("Product updated data: " + productsSingle);

                    System.out.println();//using get and set for product name attribute
                    System.out.print("Change product name: ");
                    String editName = sc.nextLine();
                    productsSingle.setName(editName);
                    System.out.println("Product Name changed to :" + productsSingle.getName());
                    System.out.print("Product updated data: " + productsSingle);
                    sc.close();
                    break;

                case 6:

                    int accountNumber;
                    String nameAccountHolder;
                    double initialDeposit, depositValue;
                    char initialDepositVerify;
                    BankAccount account;

                    System.out.println("Enter account number:");
                    accountNumber = sc.nextInt();

                    System.out.println("Enter name of the holder:");
                    sc.nextLine();
                    nameAccountHolder = sc.nextLine();

                    System.out.println("Is there an Initial deposit (y/n)?");
                    initialDepositVerify = sc.next().charAt(0);

                    if (initialDepositVerify == 'y') {
                        System.out.print("Enter initial deposit value: ");
                        initialDeposit = sc.nextDouble();
                        account = new BankAccount(accountNumber, nameAccountHolder, initialDeposit);
                    } else {
                        account = new BankAccount(accountNumber, nameAccountHolder);
                    }

                    System.out.println();
                    System.out.println("Account Info:");
                    System.out.println(account);

                    System.out.println();
                    System.out.print("Enter a deposit value:");
                    depositValue = sc.nextDouble();
                    account.deposit(depositValue);
                    System.out.println("Updated account data:");
                    System.out.println(account);

                    System.out.println();
                    System.out.print("Enter a withdraw value:");
                    depositValue = sc.nextDouble();
                    account.withdraw(depositValue);
                    System.out.println("Updated account data:");
                    System.out.println(account);
                    sc.close();
                    break;

                case 7:

                    int rentNumber, roomNumber;
                    String nameStudent, email;

                    System.out.println("How many rooms will be rented?");
                    rentNumber = sc.nextInt();

                    RoomRent[] roomRents = new RoomRent[10];

                    for (int i = 0; i < rentNumber; i++) {
                        System.out.println("\nRENT#" + (i + 1) + ":");

                        System.out.print("Name: ");
                        sc.nextLine();
                        nameStudent = sc.nextLine();

                        System.out.print("Email: ");
                        email = sc.nextLine();

                        System.out.print("Room Number: ");
                        roomNumber = sc.nextInt();

                        roomRents[roomNumber] = new RoomRent(nameStudent, email, roomNumber);
                    }

                    System.out.println("\nRented Rooms:");

                    for (RoomRent roomRent : roomRents) {
                        if (roomRent != null) {
                            System.out.println(roomRent);
                        }
                    }
                    sc.close();
                    break;

                case 8:
                    int id, numberEmployees, argId;
                    String nameEmployee;
                    double salary, percentValue;
                    //ListedEmployee listedEmployee;
                    List<ListedEmployee> listedEmployeeList = new ArrayList<>();

                    System.out.println("How many employees will be registered?");
                    numberEmployees = sc.nextInt();

                    for (int i = 0; i < numberEmployees; i++) {
                        System.out.println("\nEmployee#" + (i + 1) + ":");

                        System.out.print("Id: ");
                        sc.nextLine();
                        id = sc.nextInt();

                        System.out.print("Name: ");
                        sc.nextLine();
                        nameEmployee = sc.nextLine();

                        System.out.print("Salary: ");
                        salary = sc.nextDouble();

                        ListedEmployee listedEmployeeP = new ListedEmployee(nameEmployee, id, salary);

                        //listedEmployee.addToList(listedEmployee);
                        listedEmployeeList.add(listedEmployeeP);
                    }

                    System.out.println();
                    System.out.println("Enter the employee id that will have salary increase:");
                    argId = sc.nextInt();

                    ListedEmployee listedEmployeeU = listedEmployeeList.stream().filter(listedEmployee1 -> listedEmployee1.getId() == argId).findFirst().orElse(null);

                    if (listedEmployeeU == null) {

                        System.out.println("The id isn't valid");
                    } else {

                        System.out.println("Enter the percentage");
                        percentValue = sc.nextDouble();

                        listedEmployeeU.salaryIncrease(percentValue);

                        //double percentIncrease = listedEmployee.getSalary() * (percentValue / 100);
                        //return listedEmployee.salary = listedEmployee.getSalary() + percentIncrease;
                    }


                    for (ListedEmployee listedEmployees : listedEmployeeList) {
                        System.out.println(listedEmployees);
                    }

                case 9:
                    int rows, columns, columnsCounter, rowsCounter, numberChosen;

                    System.out.println("Insert rows number:");
                    rows = sc.nextInt();

                    System.out.println("Insert columns number:");
                    columns = sc.nextInt();

                    int[][] matrix = new int[rows][columns];

                    for (rowsCounter = 0; rowsCounter < matrix.length; rowsCounter++) {
                        for (columnsCounter = 0; columnsCounter < matrix[rowsCounter].length; columnsCounter++) {
                            System.out.println("Insert integer number:");
                            int numberValues = sc.nextInt();
                            matrix[rowsCounter][columnsCounter] = numberValues;
                        }
                    }


                    System.out.println("Which number should be analyzed within the matrix:");
                    numberChosen = sc.nextInt();

                    for (rowsCounter = 0; rowsCounter < matrix.length; rowsCounter++) {
                        for (columnsCounter = 0; columnsCounter < matrix[rowsCounter].length; columnsCounter++) {
                            if (matrix[rowsCounter][columnsCounter] == numberChosen) {
                                System.out.println("Position " + rowsCounter + "," + columnsCounter + ":\n");
                                if (rowsCounter > 0) {
                                    System.out.println("Down: " + matrix[rowsCounter - 1][columnsCounter] + "\n");
                                    if (columnsCounter < matrix[rowsCounter].length) {
                                        System.out.println("Right: " + matrix[rowsCounter][columnsCounter + 1] + "\n");
                                        if (columnsCounter > 0) {
                                            System.out.println("Left: " + matrix[rowsCounter][columnsCounter - 1] + "\n");
                                            if (rowsCounter < matrix[rowsCounter].length) {
                                                System.out.println("Up: " + matrix[rowsCounter + 1][columnsCounter] + "\n");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    sc.close();
                    break;
                case 10:
                    System.out.println("Client data:");
                    sc.nextLine();
                    System.out.print("Insert client name:");
                    String clientName = sc.nextLine();
                    System.out.print("Insert client email:");
                    String clientEmail = sc.next();
                    System.out.print("Insert client birthday (dd/mm/yyyy):");
                    Date birthday = simpleDateFormat.parse(sc.next());

                    Client client = new Client(clientName, clientEmail, birthday);

                    System.out.println("\nOrder data");

                    System.out.print("Insert order status (Pending_Payment;Processing;Shipped;Delivered):");
                    OrderStatus orderStatus = OrderStatus.valueOf(sc.next());

                    Order order = new Order(new Date(), orderStatus, client);

                    System.out.print("How many items to this order:");
                    int nrOfItems = sc.nextInt();
                    for (int i = 1; i <= nrOfItems; i++) {
                        System.out.println("Enter #" + i + " item data:");

                        System.out.print("Insert product name:");
                        sc.nextLine();
                        String productNames = sc.nextLine();

                        System.out.print("Insert product price:");
                        double productPrices = sc.nextDouble();

                        System.out.print("Insert product quantity for purchase:");
                        int productQuantity = sc.nextInt();

                        Product product = new Product(productNames, productPrices);

                        OrderItem item = new OrderItem(productQuantity, productPrices, product);

                        order.addItem(item);

                    }

                    System.out.println();
                    System.out.println(order);
                    sc.close();
                    break;

                case 11:

                    List<InheritanceCastedClassesEntities.Products> listedProducts = new ArrayList<>();

                    System.out.print("Enter the number of products: ");
                    int nrOfProducts = sc.nextInt();

                    for (int i = 1; i <= nrOfProducts; i++) {
                        System.out.println("Product #" + i + " data:");
                        System.out.print("Common, used or imported (c/u/i)? ");
                        char type = sc.next().charAt(0);
                        System.out.print("Name: ");
                        sc.nextLine();
                        String productsName = sc.nextLine();
                        System.out.print("Price: ");
                        double productsPrice = sc.nextDouble();

                        if (Character.toLowerCase(type) == 'c') {
                            Products productsCommon = new Products(productsName, productsPrice);
                            listedProducts.add(productsCommon);
                        } else if (Character.toLowerCase(type) == 'u') {
                            System.out.print("Manufacture date (DD/MM/YYYY): ");
                            Date date = simpleDateFormat.parse(sc.next());
                            UsedProducts productsUsed = new UsedProducts(productsName, productsPrice, date);
                            listedProducts.add(productsUsed);
                        } else {
                            System.out.print("Customs fee: ");
                            double customsFee = sc.nextDouble();
                            ImportedProducts productsImported = new ImportedProducts(productsName, productsPrice, customsFee);
                            listedProducts.add(productsImported);
                        }
                    }

                    System.out.println();
                    System.out.println("PRICE TAGS:");
                    for (Products products : listedProducts) {
                        System.out.println(products.tag());
                    }
                    sc.close();
                    break;

                case 12:

                    List<TaxPayer> taxPayerList = new ArrayList<>();
                    double sumOfAllTax = 0;
                    System.out.println("Enter the number of tax Payers:");
                    int nrOfTaxPayers = sc.nextInt();

                    for (int i = 1; i <= nrOfTaxPayers; i++) {
                        System.out.println("Enter tax payer #" + i + " data:");
                        System.out.print("Individual or company(i/c)");
                        char taxPayerType = sc.next().charAt(0);

                        System.out.print("Enter name:");
                        sc.nextLine();
                        String taxPayerName = sc.nextLine();

                        System.out.print("Enter Annual Income:");
                        double annualIncome = sc.nextDouble();

                        if (Character.toLowerCase(taxPayerType) == 'i') {
                            System.out.print("Enter healthExpenditure:");
                            double healthExpenditure = sc.nextDouble();

                            //TaxPayer taxPayer = new Individual(taxPayerName, annualIncome, healthExpenditure);
                            taxPayerList.add(new Individual(taxPayerName, annualIncome, healthExpenditure));

                        } else {
                            System.out.print("Enter number of employees:");
                            int nrOfEmployees = sc.nextInt();

                            TaxPayer taxPayer = new Company(taxPayerName, annualIncome, nrOfEmployees);
                            taxPayerList.add(taxPayer);

                        }
                    }
                    System.out.println("Taxes Paid:");
                    for (TaxPayer taxPayer : taxPayerList) {
                        double tax = taxPayer.taxTotal();
                        System.out.println(taxPayer.getName() + ":" + taxPayer.taxTotal());
                        sumOfAllTax += tax;
                    }

                    System.out.println();
                    System.out.println("TOTAL TAXES:" + String.format("%.2f", sumOfAllTax) + "€");
                    sc.close();
                    break;

                case 13:

                    boolean validInput = false;

                    System.out.println("Enter account data");
                    System.out.print("Number: ");
                    int number = sc.nextInt();
                    System.out.print("Holder: ");
                    sc.nextLine();
                    String holder = sc.nextLine();
                    System.out.print("Initial balance: ");
                    double balance = sc.nextDouble();
                    System.out.print("Withdraw limit: ");
                    double withdrawLimit = sc.nextDouble();

                    Account acc = new Account(number, holder, balance, withdrawLimit);
                    do {
                        System.out.println();
                        System.out.print("Enter amount for withdraw: ");
                        double amount = sc.nextDouble();
                        try {
                            acc.withdraw(amount);
                            System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
                            validInput = true;
                        } catch (DomainException e) {
                            System.out.println("Withdraw error: " + e.getMessage());
                        }
                    } while (!validInput);
                    sc.close();
                    break;

                case 14:
                    List<Product> list = new ArrayList<>();

                    System.out.println("Enter file path: ");
                    String sourceFileStr = sc.nextLine();

                    File sourceFile = new File(sourceFileStr);
                    String sourceFolderStr = sourceFile.getParent();

                    boolean success = new File(sourceFolderStr + "\\out").mkdir();

                    String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

                    try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

                        String itemCsv = br.readLine();
                        while (itemCsv != null) {

                            String[] fields = itemCsv.split(",");
                            String name = fields[0];
                            double price = Double.parseDouble(fields[1]);
                            int quantityProd = Integer.parseInt(fields[2]);

                            list.add(new Product(name, price, quantityProd));

                            itemCsv = br.readLine();
                        }

                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

                            for (Product item : list) {
                                bw.write(item.getName() + "," + String.format("%.2f", item.totalProd()));
                                bw.newLine();
                            }

                            System.out.println(targetFileStr + " CREATED!");

                        } catch (IOException e) {
                            System.out.println("Error writing file: " + e.getMessage());
                        }

                    } catch (IOException e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }

                    sc.close();

                    break;
                default:
                    System.out.println("Program exiting");
                    break;
            }

        } while (opt != 0);
        sc.close();
    }
}

/*
 System.out.println("Insert path to file");
         String pathRead = sc.nextLine();

         File pathR= new File(pathRead);

         try (BufferedReader br = new BufferedReader(new FileReader(pathRead))) {
         String line = br.readLine();
         while (line != null) {
         System.out.println(line);
         line = br.readLine();
         }
         } catch (IIOException | FileNotFoundException e) {
         System.out.println("Error: " + e.getMessage());
         } catch (IOException e) {
         e.printStackTrace();
         }

         case 15:
         System.out.println("Do you want to create file Y/N(no if file already exists)");
         char fileOpt=sc.next().charAt(0);

         System.out.println("Insert path to file");
         String pathWriterFile = sc.nextLine();
         File filePathWriter= new File(pathWriterFile);


         if (Character.toLowerCase(fileOpt) == 'y') {
         try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePathWriter))) {

         System.out.println("Insira a informação (ou insira quit para sair):\n");
         String data;
         do{
         data = sc.nextLine();
         bw.write(data);
         bw.newLine();

         }while (!data.equalsIgnoreCase("Quit"));
         } catch (IIOException | FileNotFoundException e) {
         System.out.println("Error: " + e.getMessage());
         } catch (IOException e) {
         e.printStackTrace();
         }
         }else{
         try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathWriterFile,true))) {
         System.out.println("Insira a informação (ou insira quit):\n");
         String data;
         do{
         data = sc.nextLine();
         bw.write(data);
         bw.newLine();

         }while (!data.equalsIgnoreCase("Quit"));
         } catch (IIOException | FileNotFoundException e) {
         System.out.println("Error: " + e.getMessage());
         } catch (IOException e) {
         e.printStackTrace();
         }

         }

 */