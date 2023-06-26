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
                output = "<p style='color: red'>Error! Command not found!</p> \n"+
                         "<p> Try with one of these instead: </p> \n" +
                         "<ul> \n" +
                         "<li> all </li> \n" +
                         "<li> all_sorted </li> \n" +
                         "<li> more_expensive_suite </li> </ul> \n";
                break;
        }

        return output;
    }
}
