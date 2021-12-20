package by.bsuir.app.dao.impl;

import by.bsuir.app.dao.CurrencyDao;
import by.bsuir.app.entity.Currency;

import java.util.List;
import java.util.Optional;

public class CurrencyDaoImpl implements CurrencyDao {
    @Override
    public List<Currency> findAll() {
        return null;
    }

    @Override
    public Optional<Currency> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Currency currency) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Currency currency) {
        return false;
    }
}
