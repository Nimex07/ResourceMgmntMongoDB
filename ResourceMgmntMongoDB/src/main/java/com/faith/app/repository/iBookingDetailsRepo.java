package com.faith.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.faith.app.model.BookingDetails;

public interface iBookingDetailsRepo extends MongoRepository<BookingDetails, Long> {

	@Query("{pending:'Y'}")
	List<BookingDetails> listAllBooking();

	@Query("{'resourceDetails.resourceId':?0, 'startDate' : {$gte : ?1, $lte : ?2}}")
	List<BookingDetails> viewReport(Long resourceId, LocalDate startDate, LocalDate endDate);

	@Query("{'resourceDetails.resourceId':?0, 'startDate' : {$gte : ?1, $lte : ?2}, 'bookingStatus':'Y'}")
	List<BookingDetails> viewAcceptedReport(Long resourceId, LocalDate startDate, LocalDate endDate);

	@Query("{'resourceDetails.resourceId':?0, 'startDate' : {$gte : ?1, $lte : ?2}, 'bookingStatus':'N'}")
	List<BookingDetails> viewRejectedReport(Long resourceId, LocalDate startDate, LocalDate endDate);
}
