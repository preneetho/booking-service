package com.upgrad.sweethome.booking.dao;

import com.upgrad.sweethome.booking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingDao extends JpaRepository <Booking, String> {

    public List<Booking> findByAadharNumber (String aadharNumber);
}
