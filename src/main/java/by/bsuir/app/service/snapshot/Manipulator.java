package by.bsuir.app.service.snapshot;

import by.bsuir.app.dao.ContractDao;
import by.bsuir.app.dao.impl.ContractDaoImpl;
import by.bsuir.app.entity.Contract;

import java.util.List;


public class Manipulator {
    private Originator originator = new Originator();
    private Caretaker caretaker = new Caretaker();
    private ContractDao contractDao = new ContractDaoImpl();

    public boolean saveObjectInMemory() {
        List<Contract> marks = contractDao.findAll();

        originator.setStorage(marks);

        caretaker.setMemento(originator.createMemento());
        System.out.println(caretaker.getMemento().getStorage());

        return true;
    }

    public boolean getObjectFromMemory() {
        Memento storage = caretaker.getMemento();
        List<Contract> marks = (List<Contract>) storage.getStorage();
        if (marks == null)
            return false;

//        contractDao.hqlTruncate("Mark");
//
//        for (Contract m : marks)
//            contractDao.save(m);

        return true;
    }
}
