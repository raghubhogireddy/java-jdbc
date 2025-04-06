package com.learn.io.data.dao;

import com.learn.io.data.entity.Service;
import com.learn.io.data.utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

public class ServiceDao implements Dao<Service, UUID> {

    private static final Logger LOGGER = Logger.getLogger(ServiceDao.class.getName());

    private static final String GET_ALL = "select service_id, name, price from wisdom.services";
    private static final String GET_BY_ID = "select service_id, name, price from wisdom.services where service_id=?";
    private static final String CREATE = "insert into wisdom.services (service_id, name, price) values (?, ?, ?)";

    @Override
    public List<Service> getAll() {
        List<Service> services = new ArrayList<>();
        Connection connection = DatabaseUtils.getConnection();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            services = processResultSet(resultSet);
        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("ServiceDao.getAll", e, LOGGER);
        }

        return services;
    }

    @Override
    public Service create(Service entity) {
        UUID serviceId = UUID.randomUUID();
        Connection connection = DatabaseUtils.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(CREATE);
            statement.setObject(1, serviceId);
            statement.setString(2, entity.getName());
            statement.setBigDecimal(3, entity.getPrice());
            statement.execute();
            connection.commit();
            statement.close();
        }catch (SQLException e) {
            try{
                connection.rollback();
            }catch (SQLException sqlE) {
                DatabaseUtils.handleSqlException("ServiceDao.create.rollback", sqlE, LOGGER);
            }
            DatabaseUtils.handleSqlException("ServiceDao.create", e, LOGGER);
        }

        Optional<Service> service = getOne(serviceId);
        return service.orElse(null);

    }

    @Override
    public Optional<Service> getOne(UUID id) {
        try(PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<Service> services = processResultSet(resultSet);
            if (services.isEmpty()) return Optional.empty();
            return Optional.of(services.get(0));
        }catch (SQLException e) {
            DatabaseUtils.handleSqlException("ServiceDao.getOne", e, LOGGER);
        }
        return Optional.empty();
    }

    @Override
    public Service update(Service entity) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    private List<Service> processResultSet(ResultSet rs) throws SQLException {
        List<Service> services = new ArrayList<>();
        while (rs.next()) {
            Service service = new Service();
            service.setServiceId((UUID) rs.getObject("service_id"));
            service.setName(rs.getString("name"));
            service.setPrice(rs.getBigDecimal("price"));
            services.add(service);
        }
        return services;
    }



}
