package aej.repository;

import aej.model.Costumer;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CostumerImpl implements CostumerRespository {
    private final Connection connection;

    public CostumerImpl(Connection connection) {
        this.connection = connection;
    }

    @SneakyThrows
    @Override
    public void save(Costumer costumer) {
        try {
            String query = "INSERT INTO costumer(id, costumer_name, nif, phone_number, balance_to_pay) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, costumer.getId());
                statement.setString(2, costumer.getCostumer_name());
                statement.setString(3, costumer.getNif());
                statement.setString(4, costumer.getPhone_number());
                statement.setString(5, costumer.getBalance_to_pay());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Costumer findById(String id) {
        return null;
    }

    @Override
    public void update(Costumer costumer) {

    }

    @Override
    public void delete(String id) {

    }
}