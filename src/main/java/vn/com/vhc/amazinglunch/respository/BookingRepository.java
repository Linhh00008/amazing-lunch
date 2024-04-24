package vn.com.vhc.amazinglunch.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.vhc.amazinglunch.entity.Booking;
import vn.com.vhc.amazinglunch.entity.TableOrder;
import vn.com.vhc.amazinglunch.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value = "select * from bookings where booking_id = : booking_id, user_id =: user_id, tableOrder_id = : tableOrder_id", nativeQuery = true)
    List<Booking> findBookingWithBookingId(@Param("booking_id") int booking_id);
    List<User> findUserWithUserId(@Param("user_id") int user_id);

    List<TableOrder> findTableOrderWithTableOrderId(@Param("tableOrder_id") int tableOrder_id);

    Optional<Booking> findByName(String name);

    Booking save(Booking booking);

    Booking saveAndFlush(Booking booking);

    void delete(Booking booking);

}
