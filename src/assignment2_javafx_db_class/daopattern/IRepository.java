package assignment2_javafx_db_class.daopattern;

import java.util.ArrayList;

public interface IRepository <C>{
    ArrayList<C> getAll();
    Boolean create(C c);
    Boolean update(C c);
    Boolean delete(C c);
    C find(Integer id);
}
