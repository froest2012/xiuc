package net.xiuc.design.factory;

/**
 * Created by 秀川 on 16/3/13.
 */
public class MainTest {
    public static void main(String[] args) {
        Leifeng underGraduate = new UnderGraduateFactory().creaeFactory();
        underGraduate.buyRice();
        underGraduate.sweep();
        underGraduate.wash();
        Leifeng volunteer = new VolunteerFactory().creaeFactory();
        volunteer.buyRice();
        volunteer.sweep();
        volunteer.wash();
    }

}
