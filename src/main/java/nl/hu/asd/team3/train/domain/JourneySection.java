package nl.hu.asd.team3.train.domain;

import nl.hu.asd.team3.company.domain.Location;
import nl.hu.asd.team3.train.adapter.repository.ActivityRepository;
import nl.hu.asd.team3.train.adapter.service.JourneySectionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class JourneySection {
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = ThreadLocalRandom.current().nextLong(1, 100000); // Just for demo
    private Location origin;
    private Location destination;
    private List<Activity> activities = new ArrayList<>();
    private Long customerId;
    private ActivityRepository activityRepository;

    public JourneySection(ActivityRepository activityRepository, JourneySectionService journeySectionService, String originLocationId, String destinationLocationId, Long customerId) {
        this.customerId = customerId;
        this.activityRepository = activityRepository;

        Optional<Location> location = journeySectionService.findByLocationPrimaryCode(originLocationId);

        if (location.isPresent()) {
            this.setOrigin(location.get());
        }

        location = journeySectionService.findByLocationPrimaryCode(destinationLocationId);
        if (location.isPresent()) {
            this.setDestination(location.get());
        }
    }

    public JourneySection() {
    }

    public void update(JourneySectionDTO journeySectionDTO) {
        this.clearActivities();
        for (String activity : journeySectionDTO.getActivities()) {
            Optional<Activity> foundActivity = activityRepository.findById(activity);
            // TODO: add checks
            if (foundActivity.isEmpty()) return;
            this.addActivity(foundActivity.get());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public void clearActivities() {
        this.activities.clear();
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "JourneySection{" +
                "id=" + id +
                ", origin=" + origin +
                ", destination=" + destination +
                ", activities=" + activities.stream().map(Objects::toString).collect(Collectors.joining(", ")) +
                ", customerId=" + customerId +
                '}';
    }
}
