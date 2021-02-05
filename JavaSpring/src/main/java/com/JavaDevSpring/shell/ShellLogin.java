package com.JavaDevSpring.shell;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public  class ShellLogin {

    public String getUserName() {
        return userName;
    }

    private static String userName = null;


    //TODO: Доработать
    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(String userName) {
            while (userName == null) {
                this.userName = userName;
                System.out.println("Для начала работ необходимо залогиниться: 'l' 'свой логин'");
            }
            if (userName == null) {
                System.out.println("Для начала работ необходимо залогиниться: 'l' 'свой логин'");
            } else {
            }
        return String.format("Добро пожаловать: %s", userName);
    }

}
