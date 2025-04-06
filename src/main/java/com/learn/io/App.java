package com.learn.io;

import com.learn.io.data.dao.ServiceDao;
import com.learn.io.data.entity.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Database Connectivity App
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

        Service newService = new Service();
        newService.setName("MyService_" + System.currentTimeMillis());
        newService.setPrice(new BigDecimal("99.95"));
        Service addedService = serviceDao.create(newService);
        System.out.println("\n ** CREATE **\n " + addedService);
    }
}
