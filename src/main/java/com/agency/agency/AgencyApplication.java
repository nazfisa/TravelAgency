package com.agency.agency;

import com.agency.agency.entity.Location;
import com.agency.agency.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AgencyApplication implements CommandLineRunner {


    @Autowired
    private LocationService locationService;

    public static void main(String[] args) {
        SpringApplication.run(AgencyApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        List<Location> locations = new ArrayList<>();

        Location location1 = new Location("Bandarban");
        Location location2 = new Location("Khagrachori");
        Location location3 = new Location("Shylet");
        Location location4 = new Location("Barishal");
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        locations.add(location4);
        for (Location location : locations){
            locationService.save((location));
        }
    }
}
