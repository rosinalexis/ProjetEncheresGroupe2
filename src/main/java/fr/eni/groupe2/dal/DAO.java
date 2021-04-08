package fr.eni.groupe2.dal;

import java.util.List;

public interface DAO <T> {

	public void insert(T u); 
	public void update (T u); 
	public T selectById(int noUtilisateur); 
	public List<T> selectAll(); 
	public void delete(T u);
}
