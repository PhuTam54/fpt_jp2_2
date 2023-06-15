package javafxdb.daopattern;

import javafxdb.model.Subject;

import java.util.ArrayList;

public class SubjectRepository implements IRepository<Subject>{
// single pattern
private static SubjectRepository instance;
    private SubjectRepository() {

    }
    public static SubjectRepository getInstance() {
        if (instance == null) {
            instance = new SubjectRepository();
        }
        return instance;
    }
    //

    @Override
    public ArrayList<Subject> getAll() {
        return null;
    }

    @Override
    public Boolean create(Subject subject) {
        return null;
    }

    @Override
    public Boolean update(Subject subject) {
        return null;
    }

    @Override
    public Boolean delete(Subject subject) {
        return null;
    }

    @Override
    public Subject find(Integer id) {
        return null;
    }
}
