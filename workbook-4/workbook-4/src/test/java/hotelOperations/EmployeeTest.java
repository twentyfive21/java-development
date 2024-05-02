package hotelOperations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void punchIn_should_return_punch_in_time() {
        // arrange
        Employee employee = new Employee(1, "Tina N", "IT", 20.0,0);
        // act
        employee.punchIn(9.0); // 9am
        // assert
        assertEquals(9.0, employee.getStartTime());
    }

    @Test
    void punchOut_should_return_punch_out_time() {
        // arrange
        Employee employee = new Employee(1, "Tina N", "IT", 20.0,0);
        // act
        employee.punchOut(17.0); // 5pm
        // assert
        assertEquals(17.0, employee.getEndTime());
    }
    void timecard_should_return_correct_time_worked(){
        // arrange
        Employee employee = new Employee(1, "Tina N", "IT", 20.0,0);
        double startTime = 9.0; // 9:00 AM
        double endTime = 17.0;  // 5:00 PM
        // act
       employee.timeCard();
        // assert
       assertEquals(endTime - startTime, employee.timeCard());
    }
}