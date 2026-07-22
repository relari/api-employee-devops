package pe.com.relari.employee.util;

import pe.com.relari.employee.model.domain.Employee;

import java.util.Collections;
import java.util.List;

public class Utils {

    private Utils() {}

    public static <T> T getFirstElementOrNull(List<T> list, Class<T> tClass) {
        return (list != null && !list.isEmpty()) ? tClass.cast(list.get(0)) : null;
    }

    public static void main(String[] args) {

        var data = DataMocks.buildEmployee();
        var datas = Collections.singletonList(data);

        System.out.println(getFirstElementOrNull(datas, Employee.class));

    }

}
