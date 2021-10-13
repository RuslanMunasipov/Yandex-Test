import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class Main {
    @BeforeAll
        static void setUp(){
            Configuration.startMaximized = true;
        }
        String fullName = "Ruslan Munasipov",
                eMailTrue = "ruslanmunasipov23@gmail.com",
                eMailFalse = "ruslanmuansipov23@gmail.com",
                address = "Saratov",
                permAddress = "Saratov, Russia";

    @Test
    public void main() throws InterruptedException {
        open("https://demoqa.com/text-box");

        //xpaths

        //div[@class = 'col-md-9 col-sm-12']//input[@placeholder = 'Full Name'] - userName
        //div[@class = 'col-md-9 col-sm-12']//input[@placeholder = 'name@example.com'] - eMail

        // заполняем
        $x("//div[@class = 'col-md-9 col-sm-12']//input[@placeholder = 'Full Name']").setValue(fullName);
        $x("//div[@class = 'col-md-9 col-sm-12']//input[@placeholder = 'name@example.com']").setValue(eMailTrue);
        $x("//div[@class = 'col-md-9 col-sm-12']//textarea[@placeholder]").setValue(address);
        $x("//div[@class = 'col-md-9 col-sm-12']//textarea[@id = 'permanentAddress']").setValue(permAddress);
        $x("//button[@id = 'submit']").click();


        // проверяем


        Assertions.assertEquals($x("//div[@class = 'border col-md-12 col-sm-12']//p[@id = 'name']").getText(), "Name:Ruslan Munasipov", "ne nashel");
        Assertions.assertEquals($x("//div[@class = 'border col-md-12 col-sm-12']//p[@id = 'email']").getText(), "Email:ruslanmunasipov23@gmail.com", "ne nashel");
        // если хотим что бы была ошибка проверки
        //Assertions.assertEquals($x("//div[@class = 'border col-md-12 col-sm-12']//p[@id = 'email']").getText(), "Email:ruslanmuansipov23@gmail.com", "ruslanmunasipov23@gmail.com)");
        Assertions.assertEquals($x("//div[@class = 'border col-md-12 col-sm-12']//p[@id = 'currentAddress']").getText(), "Current Address :Saratov", "ne nashel");
        Assertions.assertEquals($x("//div[@class = 'border col-md-12 col-sm-12']//p[@id = 'permanentAddress']").getText(), "Permananet Address :Saratov, Russia", "ne nashel");



    }

}
