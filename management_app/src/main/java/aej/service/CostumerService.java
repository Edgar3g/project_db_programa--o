package aej.service;

import aej.model.Costumer;
import aej.repository.CostumerRespository;

public class CostumerService {

     private final CostumerRespository costumerRespository;


    public CostumerService(CostumerRespository costumerRespository) {
        this.costumerRespository = costumerRespository;
    }

    public void registerCostumer(String id,String  costumer_name,String  nif,String  phone_number,String  balance_to_pay)
    {
        Costumer costumer =  new Costumer(id, costumer_name, nif, phone_number, balance_to_pay);
        costumerRespository.save(costumer);
    }
}
