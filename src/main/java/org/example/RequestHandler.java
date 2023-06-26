package org.example;

public class RequestHandler {
    private static RequestHandler INSTANCE;

    private RequestHandler() {}

    public static RequestHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RequestHandler();
        }
        return INSTANCE;
    }

    String[] cmdList = {"more_expensive_suite", "all", "all_sorted"};

    public String getAction(String inCmd) {
        String output = "";

        switch (inCmd) {
            case "more_expensive_suite":
                output = GestioneAlberghi.getInstance().getExpensive();
                break;

            case "all":
                output = GestioneAlberghi.getInstance().getAll();
                break;

            case "all_sorted":
                output = GestioneAlberghi.getInstance().getSorted();
                break;

            default:
                output = "<p>Error! Command not found!</p>";
                break;
        }

        return output;
    }
}
