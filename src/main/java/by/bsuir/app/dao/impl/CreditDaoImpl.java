package by.bsuir.app.dao.impl;

import by.bsuir.app.dao.CreditInfoDao;
import by.bsuir.app.entity.CreditInfo;

import java.util.List;
import java.util.Optional;

public class CreditDaoImpl implements CreditInfoDao {
    @Override
    public List<CreditInfo> findAll() {
        return null;
    }

    @Override
    public Optional<CreditInfo> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(CreditInfo creditInfo) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(CreditInfo creditInfo) {
        return false;
    }
}
