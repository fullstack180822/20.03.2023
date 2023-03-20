package how.com;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        MobilePhone samsung1 = new MobilePhone("1234", "samsung", 6.7f, 8.1f);
        MobilePhone samsung2 = new MobilePhone("1233", "samsung", 6.2f, 7.2f);
        MobilePhone samsung3 = new MobilePhone("1235", "samsung", 6.1f, 9.9f);

        MobilePhone iphone4 = new MobilePhone("1236", "iphone", 4.7f, 14.1f);
        MobilePhone iphone5 = new MobilePhone("1237", "iphone", 5.2f, 14.2f);
        MobilePhone iphone6 = new MobilePhone("1238", "iphone", 4.1f, 13.9f);

        ArrayList<MobilePhone> samsungs = new ArrayList<>();
        samsungs.add(samsung1);
        samsungs.add(samsung2);
        samsungs.add(samsung3);

        ArrayList<MobilePhone> iphones = new ArrayList<>();
        iphones.add(iphone4);
        iphones.add(iphone5);
        iphones.add(iphone6);

        HashMap<String, ArrayList<MobilePhone>> map_model_phone_list = new HashMap<>();
        map_model_phone_list.put("samsung", samsungs);
        map_model_phone_list.put("iphone", iphones);

        System.out.println(map_model_phone_list);

        System.out.println(MobilePhone.map_models_to_phones.keySet());

        ArrayList<MobilePhone> phones = new ArrayList<>();
        phones.add(samsung1);
        phones.add(samsung2);
        phones.add(samsung3);
        phones.add(iphone4);
        phones.add(iphone5);
        phones.add(iphone6);

        //phones.stream().limit(33).distinct().count() // 1, 1, 2, 2, 1, --> 1, 2
        phones.stream().forEach(x -> System.out.println("=== " + x + " ==="));

        var after_filter = phones.stream().filter(x -> x.m_size > 3);
        phones.add(new MobilePhone("1238", "iphone", 4.1f, 13.9f));

        System.out.println(after_filter.count());

        System.out.println(find(phones, "1238"));

        HashMap<String, MobilePhone> map_number_to_phone = new HashMap<>();
        map_number_to_phone.put(samsung1.m_number, samsung1);
        map_number_to_phone.put(samsung2.m_number, samsung2);
        map_number_to_phone.put(samsung3.m_number, samsung3);
        map_number_to_phone.put(iphone4.m_number, iphone4);
        map_number_to_phone.put(iphone5.m_number, iphone5);
        map_number_to_phone.put(iphone6.m_number, iphone6);

        System.out.println(map_model_phone_list.get("1238"));

    }

    private static MobilePhone find(ArrayList<MobilePhone> phones, String number) {
        for (var phone : phones) {
            if (phone.m_number.equals(number)) {
                return phone;
            }
        }
        return null;
    }
}
