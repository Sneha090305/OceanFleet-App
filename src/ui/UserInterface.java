package ui;

import java.util.List;
import java.util.Scanner;

import model.Vessel;
import util.VesselUtil;

public class UserInterface {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        System.out.println("Enter the number of vessels to be added");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Enter vessel details");
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split(":");

            String vesselId = data[0];
            String vesselName = data[1];
            double averageSpeed = Double.parseDouble(data[2]);
            String vesselType = data[3];

            Vessel vessel = new Vessel(vesselId, vesselName, averageSpeed, vesselType);
            vesselUtil.addVesselPerformance(vessel);
        }

        System.out.println("Enter the Vessel Id to check speed");
        String searchId = scanner.nextLine();

        Vessel searchedVessel = vesselUtil.getVesselById(searchId);
        if (searchedVessel != null) {
            System.out.println(
                    searchedVessel.getVesselId() + " | " +
                            searchedVessel.getVesselName() + " | " +
                            searchedVessel.getVesselType() + " | " +
                            searchedVessel.getAverageSpeed() + " knots"
            );
        } else {
            System.out.println("Vessel Id " + searchId + " not found");
        }

        System.out.println("High performance vessels are");
        List<Vessel> highPerformanceVessels = vesselUtil.getHighPerformanceVessels();
        for (Vessel vessel : highPerformanceVessels) {
            System.out.println(
                    vessel.getVesselId() + " | " +
                            vessel.getVesselName() + " | " +
                            vessel.getVesselType() + " | " +
                            vessel.getAverageSpeed() + " knots"
            );
        }

        scanner.close();
    }
}
