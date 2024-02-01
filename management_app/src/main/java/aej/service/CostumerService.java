package aej.service;
import aej.model.Costumer;
import aej.repository.CostumerRespository;
import java.util.UUID;

public class CostumerService {

    private final CostumerRespository costumerRespository;

    public CostumerService(CostumerRespository costumerRespository) {
        this.costumerRespository = costumerRespository;
    }

    public void registerCostumer(String costumer_name, String nif, String phone_number, String balance_to_pay) {
        String id = UUID.randomUUID().toString();

        Costumer costumer = new Costumer(id, costumer_name, nif, phone_number, balance_to_pay);
        costumerRespository.save(costumer);
    }
}
