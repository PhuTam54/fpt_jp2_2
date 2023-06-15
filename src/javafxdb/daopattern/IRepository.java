package javafxdb.daopattern;

import java.util.ArrayList;

public interface IRepository <S>{
    ArrayList<S> getAll();
    Boolean create(S s);
    Boolean update(S s);
    Boolean delete(S s);
    S find(Integer id);
}