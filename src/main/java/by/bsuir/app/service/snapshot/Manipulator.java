package by.bsuir.app.service.snapshot;

import by.bsuir.app.dao.ContractDao;
import by.bsuir.app.dao.impl.BaseDao;
import by.bsuir.app.dao.impl.ContractDaoImpl;
import by.bsuir.app.entity.BaseEntity;
import by.bsuir.app.entity.Contract;

import java.util.List;

import static by.bsuir.app.util.constants.Constants.MYSQL_TABLE_NAME_BANK;

public class Manipulator {
    private Originator originator = new Originator();
    private Caretaker caretaker = new Caretaker();
    private BaseDao baseDao = new BaseDao();
    private ContractDao contractDao = new ContractDaoImpl();

    public boolean saveObjectInMemory(Contract contract) {
        List<Contract> cars = contractDao.findAll();

        originator.setStorage(cars);

        caretaker.setMemento(originator.createMemento());
        System.out.println(caretaker.getMemento().getStorage());

        return true;
    }

    public boolean getObjectFromMemory(Contract contract) {
        Memento storage = caretaker.getMemento();
        List<Contract> contracts = (List<Contract>) storage.getStorage();
        if (contract == null)
            return false;
        baseDao.hqlTruncate(MYSQL_TABLE_NAME_BANK);

        System.out.println(contracts);
        for (Contract m : contracts)
            contractDao.save(m);

        return true;
    }
}