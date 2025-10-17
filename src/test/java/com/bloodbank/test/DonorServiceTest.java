package com.bloodbank.test;



import com.bloodbank.model.Donor;
import com.bloodbank.service.DonorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DonorServiceTest {

    private DonorService donorService;

    @BeforeEach
    void setUp() {
        // uses real DAO
        donorService = new DonorService();
    }

    @Test
    void testAddDonor() {
        Donor donor = new Donor();
        donor.setName("Alice");
        donor.setLastname("Smith");
        donor.setPhone("123456");
        donor.setGender("female");
        donor.setWeith(60);
        donor.setDateofbirth("1990-01-01");
        donor.setCin("ABC123");

        Donor saved = donorService.addDonor(donor);

        assertNotNull(saved);
        assertEquals("Alice", saved.getName());
        assertTrue(saved.getId() > 0); // id should be set by DB
    }

    @Test
    void testGetDonor() {
        Donor donor = new Donor();
        donor.setName("Bob");
        donor.setLastname("Johnson");
        donor.setPhone("123456");
        donor.setGender("male");
        donor.setWeith(70);
        donor.setDateofbirth("1990-01-01");
        donor.setCin("XYZ789");

        Donor saved = donorService.addDonor(donor);

        Donor fetched = donorService.getDonor(saved.getId());
        assertNotNull(fetched);
        assertEquals("Bob", fetched.getName());
    }
}
