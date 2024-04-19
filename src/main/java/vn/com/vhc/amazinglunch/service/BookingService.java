package vn.com.vhc.amazinglunch.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.com.vhc.amazinglunch.entity.Booking;
import vn.com.vhc.amazinglunch.respository.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    private final ModelMapper mapper;

    public List<Booking> ListAll(Booking booking_id){
        return bookingRepository.findAll();
    }
    public Optional<Booking> findById(Integer booking_id){
        return bookingRepository.findById(booking_id);
    }
    public Booking save(Booking booking_id){
        return  bookingRepository.save(booking_id);
    }
    public void deleteById(Integer booking_id){
        bookingRepository.deleteById(booking_id);
    }
}
