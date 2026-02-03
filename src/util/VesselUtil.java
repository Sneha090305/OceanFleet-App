package util;

import java.util.ArrayList;
import java.util.List;
import model.Vessel;

public class VesselUtil {

    private List<Vessel> vesselList = new ArrayList<>();

    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    public Vessel getVesselById(String vesselId) {
        for (Vessel vessel : vesselList) {
            if (vessel.getVesselId().equals(vesselId)) {
                return vessel;
            }
        }
        return null;
    }

    public List<Vessel> getVesselList() {
        return vesselList;
    }

    public void setVesselList(List<Vessel> vesselList) {
        this.vesselList = vesselList;
    }
}
