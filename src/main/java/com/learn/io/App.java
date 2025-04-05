package com.learn.io;

import com.learn.io.data.dao.ServiceDao;
import com.learn.io.data.entity.Service;

import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ServiceDao serviceDao = new ServiceDao();
        List<Service> services = serviceDao.getAll();
        System.out.println("**** Services ****");
        System.out.println("\n ** GET_ALL **");
        services.forEach(System.out::println);

        Optional<Service> service = serviceDao.getOne(services.get(0).getServiceId());
        System.out.println("\n ** GET_ONE **\n " + service.get());
    }
}
