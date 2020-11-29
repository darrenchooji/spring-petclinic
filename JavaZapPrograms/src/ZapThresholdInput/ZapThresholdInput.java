package ZapThresholdInput;

import ZapModel.ZapRiskLevels;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ZapThresholdInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("OWASP Zed Attack Proxy Threshold Input Program");
        System.out.println("========================================================");

        int high, medium, low, informational;
        System.out.print("Maximum number of High Risk Level Alerts: ");
        high = getThresholdInput();
        System.out.print("Maximum number of Medium Risk Level Alerts: ");
        medium = getThresholdInput();
        System.out.print("Maximum number of Low Risk Level Alerts: ");
        low = getThresholdInput();
        System.out.print("Maximum number of Informational Risk Level Alerts: ");
        informational = getThresholdInput();

        ZapRiskLevels zapRiskLevels = new ZapRiskLevels(high, medium, low, informational);
        try {
            FileWriter fw = new FileWriter("/var/lib/jenkins/workspace/SpringPetclinic_DevSecOps_Pipeline/JavaZapPrograms/src/ZapThreshold.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(zapRiskLevels);
            pw.close();
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
    public static int getThresholdInput() {
        Scanner input = new Scanner(System.in);
        boolean exception = true;
        int thresholdInput = 0;
        while (exception) {
            try {
                thresholdInput = input.nextInt();
                exception = false;
            } catch(InputMismatchException inputMismatchException) {
                System.out.print("\nInvalid Input!! Enter again: ");
                input.next();
            }
        }
        return thresholdInput;
    }
}