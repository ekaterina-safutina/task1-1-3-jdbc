package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        User user1 = new User("Olga", "Ivanova", (byte) 30);
        User user2 = new User("Vladimir", "Smirnov", (byte) 25);
        User user3 = new User("Ekaterina", "Kostrova", (byte) 41);
        User user4 = new User("Vladislav", "Moshkov", (byte) 62);

        //Создаем объект сервиса для работы с БД
        UserService userService = new UserServiceImpl();

        // 1. Создание таблицы User(ов)
        userService.createUsersTable();

        // 2. Добавление 4 User(ов) в таблицу
        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        user1.userToSaveString();

        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        user2.userToSaveString();

        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        user3.userToSaveString();

        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        user4.userToSaveString();

        // 3. Получение всех User из базы и вывод в консоль
        List<User> allUsers = userService.getAllUsers();
        for (User user: allUsers) {
            System.out.println(user);
        }

        // 4. Очистка таблицы User(ов)
        userService.cleanUsersTable();

        // 5. Удаление таблицы
        userService.dropUsersTable();

        // Закрытие соединения
        Util.closeConnection();
    }
}
