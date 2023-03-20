package how.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MobilePhone {

    protected String m_number;
    protected String m_model;
    protected float m_size;
    protected float os_version;

    static protected HashMap<String, ArrayList<MobilePhone>> map_models_to_phones = new HashMap<>();

    public MobilePhone(String m_number, String m_model, float m_size, float os_version) {
        this.m_number = m_number;
        this.m_model = m_model;
        this.m_size = m_size;
        this.os_version = os_version;

        ArrayList<MobilePhone> list_of_this_model;
        if (!MobilePhone.map_models_to_phones.containsKey(this.m_model)) {
            list_of_this_model = new ArrayList<>();
            MobilePhone.map_models_to_phones.put(this.m_model, list_of_this_model);
        }
        else {
            list_of_this_model = MobilePhone.map_models_to_phones.get(this.m_model);
        }
        list_of_this_model.add(this);
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "m_number='" + m_number + '\'' +
                ", m_model='" + m_model + '\'' +
                ", m_size=" + m_size +
                ", os_version=" + os_version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobilePhone that = (MobilePhone) o;
        return this.m_number.equals(that.m_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_number);
    }
}
