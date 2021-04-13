import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


public class Bot {

    Scanner in = new Scanner(System.in);

    @Commands(aliases = {"помощь", "помоги", "help"},
            args = "конкретная команда/ничего",
            description = "Выводит список команд",
            id = 1)
    public String help(String[] args) {
        StringBuilder builder = new StringBuilder("Я умею в такие команды:\n");

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(Commands.class))
                continue;

            Commands cmd = m.getAnnotation(Commands.class);

            if (args.length > 0){
                for (String alias : cmd.aliases()){
                    if (alias.equals(args[0])) {
                        builder = new StringBuilder("Информация о команде: " + cmd.aliases()[0]);
                        builder.append("\n").append(cmd.description());
                        if (cmd.args().length > 0) builder.append(": ").append(Arrays.toString(cmd.args()));
                        return builder.toString();
                    }
                }
            }
            builder.append(Arrays.toString(cmd.aliases())).append(": ").append(cmd.description()).append("\n");
        }

        return builder.toString();
    }

    @Commands(aliases = {"делитель","divider"},
            args = "число 1, число 2",
            description = "Проверяет является ли второе число делителем первого",
    id = 2)
    public String divider(String[] args) {
        if (args.length < 2) return "Недостаточно аргументов";

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        if (x%y == 0) return "да";
        if (x%y != 0) return "нет";
        return "Некоректный ввод";
    }

    @Commands(aliases = {"дата", "date"},
            description = "Показывает текущую дату",
            id = 3)
    public String date(String[] args){

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E dd.MM.yyyy ");

        return ("Текущая дата " + formatForDateNow.format(dateNow));
    }
    @Commands(aliases = {"время", " time"},
            description = "Показывает текущую дату",
            id = 4)
    public String time(String[] args){

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH:mm:ss");

        return ("Текущее время " + formatForDateNow.format(dateNow));
    }

    @Commands(aliases = {"калькулятор", "calculator"},
            args = "число 1, число 2, операция",
            description = "Вычисляет сумму/разность/произведение/частное двух чисел",
            id = 5)
    public String calculator(String[] args) {
        if (args.length < 3) return "Недостаточно аргументов";

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        if (args[2].equals("+")) return " " + (x + y);
        if (args[2].equals("-")) return " " + (x - y);
        if (args[2].equals("*")) return " " + (x * y);
        if (args[2].equals("/")) return " " + (x / y);

        return "Некоректный ввод";
    }

    @Commands(aliases = "сравни",
    args = "число 1, число 2",
    description = "Сравнивает 2 числа",
    id = 6, inProgress = true)
    public String compare(String[] args){
        if (args.length < 2) return "Недостаточно аргументов";

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        if (x > y) return x + " > " + y;
        if (x < y) return x + " < " + y;
        if (x == y) return x + " = " + y;
        return "Некоректный ввод";
    };

    @Commands(aliases = {"команды", "commands"},
            description = "Выводит список доступных реализованных команд, потом список команд, которые находятся в разработке",
            id = 7)
    public String commands(String[] args) {

        StringBuilder commandsTrue = new StringBuilder("Доступные команды:\n");
        StringBuilder commandsFalse = new StringBuilder("Команды, находящиеся в разработке:\n");

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(Commands.class))
                continue;

            Commands cmd = m.getAnnotation(Commands.class);

            if (cmd.inProgress()) commandsFalse.append(cmd.aliases()[0]).append("\n");
            else commandsTrue.append(cmd.aliases()[0]).append("\n");
        }
        return commandsTrue + "\n" + commandsFalse;
    }


    private HashMap<String, Method> commands;

    public Bot() {
        commands = new HashMap<>();

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(Commands.class))
                continue;

            Commands cmd = m.getAnnotation(Commands.class);
            for (String name : cmd.aliases())
                commands.put(name, m);
        }
    }

    public String processUserInput(String input) {
        if (input.isEmpty())
            return "Я вас не понимаю";

        String[] splitted = input.split(" ");
        String command = splitted[0].toLowerCase();
        String[] args = Arrays.copyOfRange(splitted, 1, splitted.length);

        Method m = commands.get(command);

        if (m == null)
            return "Я вас не понимаю";

        try {
            return (String) m.invoke(this, (Object) args);
        } catch (Exception e) {
            return "Что-то пошло не так, попробуйте ещё раз";
        }
    }

}

