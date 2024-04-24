package vn.com.vhc.amazinglunch.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.vhc.amazinglunch.entity.Booking;
import vn.com.vhc.amazinglunch.service.BookingService;

import java.util.List;
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        List<Booking> bookings = bookingService.ListAll();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        Booking createBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(createBooking, HttpStatus.CREATED);
    }

    @PutMapping("/{booking_id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("booking_id") Integer booking_id, @RequestBody Booking bookingDetails){
        Booking updateBooking = bookingService.updateBooking(booking_id, bookingDetails);
        if(updateBooking != null){
            return new ResponseEntity<>(updateBooking, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{booking_id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable("booking_id") Integer booking_id){
        bookingService.deleteById(booking_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
