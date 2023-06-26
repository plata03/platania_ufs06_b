package org.example;


import java.util.ArrayList;
import java.util.List;

public class GestioneAlberghi {
    private static GestioneAlberghi INSTANCE;
    private List<Albergo> hotelList = new ArrayList();

    private GestioneAlberghi() {
        hotelList.add(new Albergo("Questo hotel...", 3, "Trivago", 12000, true));
        hotelList.add(new Albergo("Quel bellissimo hotel...", 5, "Gran se- sasso!", 13000, true));
        hotelList.add(new Albergo("Codesto albergo...", 4, "Dolomiti", 10000, true));
        hotelList.add(new Albergo("Sulla panca la capra...", 8, "Marina", 19000, false));
    }

    public static GestioneAlberghi getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GestioneAlberghi();
        }
        return INSTANCE;
    }

    public String getAll() {
        String s = "<tr>";

        for (Albergo albergo:
                hotelList) {
            s += (
                    "<td>" + albergo.getDesc() + "</td>" +
                    "<td>" + albergo.getId() + "</td>" +
                            "<td>" + albergo.getName() + "</td>" +
                            "<td>" + albergo.getPrice() + "</td>" +
                            "<td>" + albergo.isSuite() + "</td>" +
                            "</tr>\n"
            );
        }

        return s;
    }

    public String getExpensive() {
        Albergo mostExpensive = null;
        for (int i = 0; i < hotelList.size()-1; i++) {
            Albergo car1 = hotelList.get(i);
            Albergo car2 = hotelList.get(i+1);

            if (car1.getPrice() > car2.getPrice()) {
                if(car1.isSuite()) {
                    mostExpensive = car1;
                }

            } else {
                if(car2.isSuite()) {
                    mostExpensive = car2;
                }

            }
        }

        String s = "<tr>"+
                "<td>" + mostExpensive.getDesc() + "</td>" +
                "<td>" + mostExpensive.getId() + "</td>" +
                "<td>" + mostExpensive.getName() + "</td>" +
                "<td>" + mostExpensive.getPrice() + "</td>" +
                "<td>" + mostExpensive.isSuite() + "</td>" +
                "</tr>\n";

        return s;
    }

    public String getSorted() {
        List<Albergo> listCopy = new ArrayList<>();
        listCopy.addAll(hotelList);

        listCopy.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });

        String s = "<tr>";

        for (Albergo albergo:
                listCopy) {
            s += (
                    "<td>" + albergo.getDesc() + "</td>" +
                    "<td>" + albergo.getId() + "</td>" +
                            "<td>" + albergo.getName() + "</td>" +
                            "<td>" + albergo.getPrice() + "</td>" +
                            "<td>" + albergo.isSuite() + "</td>" +
                            "</tr>\n"
            );
        }

        return s;
    }
}
