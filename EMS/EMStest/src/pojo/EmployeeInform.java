package pojo;

public class EmployeeInform {
    private String job_number;
    private String name;
    private double salary;
    private Integer age;
    private String    power;
    private  String    address;

    public double getSalary() {
        return salary;
    }

    public EmployeeInform(String job_number, String name, double salary, Integer age, String power, String address) {
        this.job_number = job_number;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.power = power;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EmployeeInform() {
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_number() {
        return job_number;
    }

    public void setJob_number(String job_number) {
        this.job_number = job_number;
    }

    @Override
    public String toString() {
        return "employeeInform{" +
                "job_number='" + job_number + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", power=" + power +
                '}';
    }
}
