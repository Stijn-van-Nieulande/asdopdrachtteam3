package nl.hu.asd.team3.train.domain;


import java.util.ArrayList;
import java.util.List;

public class JourneySectionDTO {
    private List<String> activities = new ArrayList<>();

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }
}
