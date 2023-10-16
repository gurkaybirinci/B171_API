package herokuapp_smoketest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                TC01_CreateBooking.class,
                TC02_GetBooking.class,
                TC03_UpdateBooking.class,
                TC04_PartialUpdateBooking.class
        }
)

public class Runner {
}
