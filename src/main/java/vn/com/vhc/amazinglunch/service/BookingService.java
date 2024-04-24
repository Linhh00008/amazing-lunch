package vn.com.vhc.amazinglunch.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.com.vhc.amazinglunch.entity.Booking;
import vn.com.vhc.amazinglunch.entity.TableOrder;
import vn.com.vhc.amazinglunch.entity.User;
import vn.com.vhc.amazinglunch.respository.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    private final ModelMapper mapper;

    public List<Booking> ListAll(){
        return bookingRepository.findAll();
    }
    public Optional<Booking> findById(Integer booking_id){
        return bookingRepository.findById(booking_id);
    }
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
    public Booking updateBooking(Integer nooking_id, Booking bookingDetails) {
        Booking booking = bookingRepository.findById(nooking_id).orElse(null);
        if (booking != null) {
            booking.setUpdate_at(bookingDetails.getUpdate_at());
            // Cập nhật các thông tin khác nếu cần thiết
            return bookingRepository.save(booking);
        }
        return null;
    }
    public void deleteById(Integer booking_id){
        bookingRepository.deleteById(booking_id);
    }

    public List<Booking> findBookingWithBookingId(int bookingId) {
        return bookingRepository.findBookingWithBookingId(bookingId);
    }

    public List<User> findUserWithUserId(int userId) {
        return bookingRepository.findUserWithUserId(userId);
    }

    public List<TableOrder> findTableOrderWithTableOrderId(int tableOrderId) {
        return bookingRepository.findTableOrderWithTableOrderId(tableOrderId);
    }
    public Optional<Booking> findByName(String name) {
        return bookingRepository.findByName(name);
    }

}
