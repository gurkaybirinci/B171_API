package pojos.herokuapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponsePojo {
    private BookingPojo booking;

    public BookingResponsePojo() {
    }

    public BookingResponsePojo(BookingPojo booking) {
        this.booking = booking;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponsePojo{" +
                "booking=" + booking +
                '}';
    }
}
