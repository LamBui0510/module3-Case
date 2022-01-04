package service;

import dao.ManagerDao;
import model.Manager;

import java.util.List;

public class ManagerServiceImpl implements IService<Manager>{
    ManagerDao managerDao = new ManagerDao();

    @Override
    public List<Manager> getList() {
        return managerDao.getListManager();
    }

    @Override
    public void save(Manager manager) {
        managerDao.createManagerDao(manager);
        getList();
    }

    @Override
    public void update(int id, Manager manager) {
        managerDao.updateManager(id, manager);
        getList();
    }

    @Override
    public void delete(int id) {
    managerDao.deleteManagerDao(id);
        getList();
    }

}
