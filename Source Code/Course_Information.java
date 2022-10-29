
public class Course_Information {
    private String course_code;
    private String date_added;
    private double credit_weight;
    private String letter_grade;
    private double percentage_grade;
    
    public Course_Information(){

    }

    public void set_course(String course_code){
        this.course_code = course_code;
    }

    public void set_date(String date_added){
        this.date_added = date_added;
    }

    public void set_credit(double credit_weight){
        this.credit_weight = credit_weight;
    }

    public void set_letter(String letter_grade){
        this.letter_grade = letter_grade;
    }

    public void set_percentage(double percentage_grade){
        this.percentage_grade = percentage_grade;
    }

    public String get_course(){
        return this.course_code;
    }

    public String get_date(){
        return this.date_added;
    }

    public double get_credit(){
        return this.credit_weight;
    }

    public String get_letter(){
        return this.letter_grade;
    }

    public double get_percentage(){
        return this.percentage_grade;
    }
}
