import java.util.ArrayList;
import java.util.Random;

public class BoBai {
    static String[] sobai = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
    static String[] chatBai = { "co", "ro", "chuon", "bich" };
    static ArrayList<LaBai> bobai = new ArrayList<LaBai>();

    BoBai() {

    }

    float tinhXacSuat(int soLanBoc, int soLaBoc, int soLuongChat) {
        taoBoBai();
        float i = 0;
        float soLanBocDung = 0;
        // chat can xet la: Co
        while (i < soLanBoc) {
            ArrayList<LaBai> laBais = bocLabai2(soLaBoc);
            boolean dungSai = xetDungSai(laBais, soLuongChat);
            if (dungSai) {
                soLanBocDung++;
            }
            i++;
        }

        return soLanBocDung / soLanBoc;
    }

    private boolean xetDungSai(ArrayList<LaBai> laBais, int soLuongChat) {
        int dem = 0;
        for (int i = 0; i < laBais.size(); i++) {
            if (laBais.get(i).chatBai == "co") {
                dem++;
            }
        }
        if (dem == soLuongChat) return true;
        return false;
    }

    // private ArrayList<LaBai> bocLabai(int soLaBai) {
    //     Random ngauNhien = new Random();
    //     ArrayList<LaBai> laBaiDaBoc = new ArrayList<>();
    //     ArrayList<LaBai> boBaiTam = new ArrayList<>(bobai);
    //     for (int i = 0; i < soLaBai; i++) {
    //             int j = boBaiTam.size();
    //             int index = ngauNhien.nextInt(j);
    //             LaBai lb = boBaiTam.get(index);
    //             boBaiTam.remove(index);
    //             laBaiDaBoc.add(i,lb);  
    //         }
    //     return laBaiDaBoc;

    // }
     private ArrayList<LaBai> bocLabai2(int soLaBai) {
        Random ngauNhien = new Random();
        ArrayList<LaBai> laBaiDaBoc = new ArrayList<>();
        ArrayList<LaBai> boBaiTam = new ArrayList<>();
        ArrayList<LaBai> boBaiTam2 = new ArrayList<>(bobai);
        for(int i= boBaiTam2.size() ; i > 0; i--){
                int index = ngauNhien.nextInt(i);
                LaBai lb = boBaiTam2.get(index);
                boBaiTam.add(lb);
                boBaiTam2.remove(index);
        }
        for(int i = 0 ; i < soLaBai; i++){
            LaBai lb = boBaiTam.get(i);
            laBaiDaBoc.add(lb);
        }
        return laBaiDaBoc;

    }

    void taoBoBai() {
        LaBai laBai;
        for (int so = 0; so < sobai.length; so++) {
            for (int chat = 0; chat < chatBai.length; chat++) {
                laBai = new LaBai();
                laBai.setSoBai(sobai[so]);
                laBai.setChatBai(chatBai[chat]);
                bobai.add(laBai);
            }
        }
    }
}
