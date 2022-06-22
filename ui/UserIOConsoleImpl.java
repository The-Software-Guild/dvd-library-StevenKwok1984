package ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{

    final private Scanner console = new Scanner(System.in);



    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readString(String msgPrompt) {
        System.out.println(msgPrompt);
        return console.nextLine();
    }



    @Override
    public int readInt(String msgPrompt) {
        boolean invalidInput = true;
        int num = 0;

        while(invalidInput) {
            try {
                String stringNum = this.readString(msgPrompt);

                num = Integer.parseInt(stringNum);
                invalidInput = false;
            } catch (NumberFormatException e) {
                this.print("Error: Please enter the integer");
            }
        }

        return num;
    }

    @Override
    public int readInt(String msgPrompt, int min, int max) {
        int result;
        do {
            result = readInt(msgPrompt);
        } while (result < min || result > max);
        return result;
    }

    @Override
    public long readLong(String msgPrompt) {
        while (true) {
            try {
                return Long.parseLong(this.readString(msgPrompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }


    @Override
    public long readLong(String msgPrompt, long min, long max) {
        long result;
        do {
            result = readLong(msgPrompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public float readFloat(String msgPrompt) {
        while (true) {
            try {
                return Float.parseFloat(this.readString(msgPrompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    @Override
    public float readFloat(String msgPrompt, float min, float max) {
        float result;
        do {
            result = readFloat(msgPrompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public double readDouble(String msgPrompt) {
        while (true) {
            try {
                return Double.parseDouble(this.readString(msgPrompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    @Override
    public double readDouble(String msgPrompt, double min, double max) {
        double result;
        do {
            result = readDouble(msgPrompt);
        } while (result < min || result > max);
        return result;
    }

    @Override
    public LocalDate readDate (String prompt) {
        LocalDate date = null;
        boolean validInput;

        do {
            try {
                System.out.println(prompt);
                System.out.println("Please input date in the format 'YYYY-MM-DD'");
                // Obtain user input, and convert it to local date
                String stringDate = console.nextLine();
                date = LocalDate.parse(stringDate);
                validInput = true;
            } catch (DateTimeException e) {
                this.print("Error: Please input the date in correct format");
                validInput = false;
            }

        } while (!validInput);
        return date;
    }




}
