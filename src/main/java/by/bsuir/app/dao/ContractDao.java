package by.bsuir.app.dao;

import by.bsuir.app.entity.Contract;
import by.bsuir.app.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface ContractDao extends BaseDao<Long, Contract>{
    List<Contract> findAllByField(String field) throws DAOException;
    List<Object[]> findAllGroupedByQuantity();


    boolean deleteByUserId(Long id);
    Optional<Contract> findByUserId(Long id);
    boolean save(Contract contract);
}
