package aej.repository;

import aej.model.Costumer;

public interface CostumerRespository {
    void save(Costumer costumer);

    Costumer findById(String id);

    void update(Costumer costumer);

    void delete(String id);
}
