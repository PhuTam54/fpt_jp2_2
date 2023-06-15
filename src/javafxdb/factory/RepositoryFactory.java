package javafxdb.factory;

import javafxdb.daopattern.IRepository;
import javafxdb.daopattern.StudentRepository;
import javafxdb.daopattern.SubjectRepository;
import javafxdb.enums.RepositoryType;

public class RepositoryFactory{
    public static IRepository createRepositoryInstance(RepositoryType type) {
        if (type == RepositoryType.SUBJECT) {
            return SubjectRepository.getInstance();
        } else if (type == RepositoryType.STUDENT) {
            return StudentRepository.getInstance();
        } else {
            return null;
        }
    }
}
