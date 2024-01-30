package aej.repository;

import aej.model.Costumer;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CostumerImpl implements CostumerRespository{
     private final Connection connection;

     public CostumerImpl(Connection connection)
     {
        this.connection = connection;
     }

    @SneakyThrows
    @Override
    public void save(Costumer costumer){
         try {
             Statement statement = connection.createStatement();
             String query = String.format("INSERT INTO costumer(id, costumer_name, nif, phone_number, balance_to_pay) VALUES ('%s','%s','%s','%s','%s')", costumer.getId(), costumer.getCostumer_name(), costumer.getNif(), costumer.getPhone_number(), costumer.getBalance_to_pay());
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
    }
}
