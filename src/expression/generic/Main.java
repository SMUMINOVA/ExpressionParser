package expression.generic;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length <= 1 || args[0] == null || args[1] == null) {
            System.out.println("Ожидаемый запуск программы: \"-i\" \"10 + 4 / 2 - 7\" ");
            return;
        }
        String operation_type = args[0].substring(1);
        String expression = args[1];
        GenericTabulator tab = new GenericTabulator();
        var t = tab.tabulate(operation_type, expression, -2, 2, -2, 2, -2, 2);
        for (Object[][] objects : t) {
            for (Object[] object : objects) {
                for (Object o : object) {
                    System.out.print(o + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
