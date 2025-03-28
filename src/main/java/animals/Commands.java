package animals;

public enum Commands {
    ADD,
    LIST,
    EXIT;

    public static Commands fromString(String command){
        try{
            return Commands.valueOf(command.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Команда " + command + " команда не опознана");
            return null;
        }
    }
}
