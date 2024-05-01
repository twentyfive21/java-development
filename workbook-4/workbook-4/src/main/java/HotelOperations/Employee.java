package HotelOperations;

import java.time.LocalDateTime;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private int hoursWorked;
    private double startTime; // Track start time when punching in
    private double endTime; // Track end time when punching in
    private LocalDateTime startClock;
    private LocalDateTime endClock;
    public Employee(int employeeId, String name, String department, double payRate, int hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay(){
        return hoursWorked * payRate;
    }
    public double getRegularHours(){
        if (hoursWorked > 40){
            return 40;
        }
        return 40;
    }
    public double getOvertimeHours(){
        if(hoursWorked > 40){
            return hoursWorked - 40;
        }
        return hoursWorked;
    }
    public double getOverTimePay(){
        return getOvertimeHours() * 1.5;
    }

    public void punchIn(double time) {
        startTime = time;
    }

    public void punchOut(double time) {
        endTime = time;
    }

    public void punchIn(){
       startClock = LocalDateTime.now();
    }
    public void punchOut(){
        endClock = LocalDateTime.now();
    }

    public double timeCard (){
        return startTime - endTime;
    }

}
