package com.faith.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faith.app.model.BookingDetails;
import com.faith.app.repository.iBookingDetailsRepo;

@Service
public class BookingDetailsService implements iBookingDetailsService {

	@Autowired
	private iBookingDetailsRepo bookingRepo;

	// inserting data
	@Transactional
	@Override
	public BookingDetails addBooking(BookingDetails bookingDetails) {
		return bookingRepo.save(bookingDetails);
	}

	// getting all data
	@Override
	public List<BookingDetails> listAllBooking() {
		return bookingRepo.listAllBooking();
	}

	// search by id
	@Override
	public BookingDetails findBookingById(Long bookingId) {
		Optional<BookingDetails> findBookingId = bookingRepo.findById(bookingId);
		BookingDetails bookingDetails = findBookingId.isPresent() ? findBookingId.get() : null;
		return bookingDetails;
	}

	// update
	@Transactional
	@Override
	public BookingDetails updateBooking(BookingDetails bookingDetails) {
		return bookingRepo.save(bookingDetails);
	}

	// total enquiry report
	@Override
	public List<BookingDetails> viewReport(Long resourceId, LocalDate startDate, LocalDate endDate) {
		return bookingRepo.viewReport(resourceId, startDate, endDate);
	}

	// total accepted report
	@Override
	public List<BookingDetails> viewAcceptedReport(Long resourceId, LocalDate startDate, LocalDate endDate) {
		return bookingRepo.viewAcceptedReport(resourceId, startDate, endDate);
	}

	// total rejected report
	@Override
	public List<BookingDetails> viewRejectedReport(Long resourceId, LocalDate startDate, LocalDate endDate) {
		return bookingRepo.viewRejectedReport(resourceId, startDate, endDate);
	}

}
