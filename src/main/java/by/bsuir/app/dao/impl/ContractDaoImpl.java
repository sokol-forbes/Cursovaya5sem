package by.bsuir.app.dao.impl;

import by.bsuir.app.dao.ContractDao;
import by.bsuir.app.entity.Contract;

import java.util.List;
import java.util.Optional;

public class ContractDaoImpl implements ContractDao {
    @Override
    public List<Contract> findAll() {
        return null;
    }

    @Override
    public Optional<Contract> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Contract contract) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Contract contract) {
        return false;
    }
}
