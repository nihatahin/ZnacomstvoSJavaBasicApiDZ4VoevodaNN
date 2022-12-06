package task3;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.IOException;
import java.util.logging.*;




public class task {
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(task.class.getName());
        FileHandler fh = new FileHandler("./task3/log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        Scanner scanner = new Scanner(System.in);

        LinkedList <Double> history = new LinkedList<>();
        



        System.out.printf("Enter first operand (double type number) or '/return' to exit the program: ");
        String cur_string = enter_num(scanner, logger);
        if (cur_string.equals("/return"))
        {
            System.out.println("You are leaving calculator. Luck!");
            logger.info("Finish program!");
            scanner.close();
            return;
        }
        else
        {
            double cur_num = Double.parseDouble(cur_string);
            logger.info(Double.toString(cur_num) + " was entered as start operand.");
            String oper;
            double num = 0;
            history.add(cur_num);
System.out.println(history.toString());
            while(true)
            {
                System.out.printf("Enter operator (+, -, *, or /) or '/cancel' to cancel last action or '/return' to exit the program: ");
                oper = enter_oper(scanner, logger);
                if (oper.equals("/return"))
                {
                    System.out.println("You are leaving calculator. Luck!");
                    logger.info("Finish program!");
                    scanner.close();
                    return;
                }
                else if (oper.equals("/cancel"))
                {
                    if (history.size() > 1)
                    {
                        history.removeLast();
                        cur_num = history.getLast();
                        System.out.printf("Last operation was canceled. Current operand: ");
                        System.out.println(cur_num);
                        logger.info("Cancel last action. Current meaning is " + cur_num);
System.out.println(history.toString());
                    }
                    else
                    {
                        System.out.println("There is no value in the memory!");
                        logger.warning("Invalid cancel. There is no value in the memory!");
                    }

                    
                    
                    continue;
                }
                else
                    logger.info(oper + " was entered as operator.");
                //---------
                System.out.printf("Enter operand (double type number) or '/return' to exit the program: ");
                cur_string = enter_num(scanner, logger);
                if (cur_string.equals("/return"))
                {
                    System.out.println("You are leaving calculator. Luck!");
                    logger.info("Finish program!");
                    scanner.close();
                    return;
                }
                else
                {
                    num = Double.parseDouble(cur_string);
                    logger.info(Double.toString(cur_num) + " was entered as operand.");
                }
                
                cur_num = operation(cur_num, num, oper.toCharArray()[0]);
                history.add(cur_num);
                String res = Double.toString(history.get(history.size() - 2)) + " " + String.valueOf(oper) + " " + Double.toString(num) + " = " + cur_num;
                System.out.println(res);
                logger.info(cur_num + " was calculated.");
System.out.println(history.toString());
                
            }
        }

    }

    
    

    public static String enter_num(Scanner iScanner, Logger iLogger) {
        String str_num = "";
        boolean is_valid = false;
        while(!is_valid)
        {
            str_num = iScanner.nextLine();
            is_valid = (str_num.equals("/return")) || (validation(str_num, iLogger));

        }
        return str_num;
    }

    public static boolean validation(String str_n, Logger logger) {
        try{
            Double.parseDouble(str_n);
            return true;    
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid value was entered! Try again: ");
            logger.warning("Invalid value was entered!");
            return false;
        }
    }
    






















    public static double operation(double n1, double n2, char o) {
        switch(o)
        {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
        }
        return 0.0;
    }

    


    public static boolean validation_ch(String str_n, Logger logger) {
        switch(str_n)
        {
            case "+":
            case "-":
            case "*":
            case "/":
            case "/return":
            case "/cancel":
                return true;
            default:
                System.out.printf("Invalid operator was entered! Try again: ");
                logger.warning("Invalid operator was entered!");
                return false;
        }
    }

    public static String enter_oper(Scanner iScanner, Logger iLogger) {
        
        String str_num = "";
        boolean is_valid = false;
        while(!is_valid)
        {
            str_num = iScanner.nextLine();
            is_valid = validation_ch(str_num, iLogger);
        }
        
        return str_num;
    }


}
